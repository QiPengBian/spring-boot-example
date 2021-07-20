package com.example.sys.handler;

import cn.hutool.json.JSONObject;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-07-12 13:39:51
 */
@Slf4j
@Component
public class CanalClient implements ApplicationRunner {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private CanalConnector connector;

    private static final String TABLE_NAME = "sys_user";
    private static final String PRIMARY_KEY = "id";
    private static final String SEPARATOR = ":";

    @Override
    public void run(ApplicationArguments args) {
        this.initCanal();
    }

    public void initCanal() {
        int batchSize = 1000;
        try {
            log.info("启动 canal 数据同步...");
            connector.connect();
            connector.subscribe(".*\\..*");
            connector.rollback();
            while (true) {
                // 获取指定数量的数据
                Message message = connector.getWithoutAck(batchSize);
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    try {
                        // 时间间隔1000毫秒
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    syncEntry(message.getEntries());
                }
                connector.ack(batchId); // 提交确认
                // connector.rollback(batchId); // 处理失败, 回滚数据
            }
        } finally {
            connector.disconnect();
        }
    }

    /**
     * @description: 数据封装
     * @author: bianqipeng
     * @date: 2021-07-13 11:14:16
     * @param: entrys
     */
    private void syncEntry(List<CanalEntry.Entry> entrys) {
        for (CanalEntry.Entry entry : entrys) {
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN
                    || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }

            CanalEntry.RowChange rowChange;
            try {
                rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR data:" + entry.toString(), e);
            }

            CanalEntry.EventType eventType = rowChange.getEventType();
            log.info("================> binlog[{}:{}] , name[{},{}] , eventType : {}",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                    eventType);

            String tableName = entry.getHeader().getTableName();
            if (!TABLE_NAME.equalsIgnoreCase(tableName)) {
                continue;
            }
            for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
                List<CanalEntry.Column> columns = rowData.getAfterColumnsList();
                // 数据封装成json
                JSONObject json = new JSONObject();
                for (CanalEntry.Column column : columns) {
                    json.put(column.getName(), column.getValue());
                }
                // 获取主键，构建redis的key
                String key = null;
                for (CanalEntry.Column column : columns) {
                    if (PRIMARY_KEY.equalsIgnoreCase(column.getName())) {
                        key = tableName + SEPARATOR + column.getValue();
                        break;
                    }
                }
                if (eventType == CanalEntry.EventType.INSERT) {
                    redisTemplate.opsForValue().set(key, json.toString());
                    log.info("redis数据同步新增，key：" + key);
                } else if (eventType == CanalEntry.EventType.UPDATE) {
                    redisTemplate.opsForValue().set(key, json.toString());
                    log.info("redis数据同步更新，key：" + key);
                } else if (eventType == CanalEntry.EventType.DELETE) {
                    redisTemplate.delete(key);
                    log.info("redis数据同步删除，key：" + key);
                }
            }
        }
    }
}

