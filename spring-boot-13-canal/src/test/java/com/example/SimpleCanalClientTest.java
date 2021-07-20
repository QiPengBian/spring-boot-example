//package com.example;
//
//import com.alibaba.otter.canal.client.CanalConnector;
//import com.alibaba.otter.canal.client.CanalConnectors;
//import com.alibaba.otter.canal.protocol.CanalEntry;
//import com.alibaba.otter.canal.protocol.CanalEntry.Column;
//import com.alibaba.otter.canal.protocol.CanalEntry.Entry;
//import com.alibaba.otter.canal.protocol.CanalEntry.EntryType;
//import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
//import com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
//import com.alibaba.otter.canal.protocol.Message;
//import com.google.protobuf.InvalidProtocolBufferException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.net.InetSocketAddress;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * @description: TODO
// * @author: bianqipeng
// * @date: 2021-07-09 10:26:08
// */
//public class SimpleCanalClientTest {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleCanalClientTest.class);
//
//    public static void main(String args[]) {
//        // 创建链接
//        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("192.168.11.130",
//                11111), "cluster", "", "");
//        try {
//            // 建立连接
//            connector.connect();
//            // 开启订阅
//            connector.subscribe(".*\\..*");
//            // 循环订阅
//            while (true) {
//                // 获取指定数量的数据
//                Message message = connector.getWithoutAck(1000);
//                long batchId = message.getId();
//                int size = message.getEntries().size();
//                if (batchId == -1 || size == 0) {
//                    try {
//                        LOGGER.info("当前暂时没有数据，休眠1秒");
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                    }
//                } else {
//                    LOGGER.info("-------------------------- 有数据啦 -----------------------");
//                    printEntry(message.getEntries());
//                }
//                // // 提交确认
//                connector.ack(batchId);
//                // connector.rollback(batchId); // 处理失败, 回滚数据
//            }
//        } finally {
//            connector.disconnect();
//        }
//    }
//
//    private static void printEntry(List<Entry> entrys) {
//        for (Entry entry : entrys) {
//
//            // 第一步：拆解entry 实体
//            CanalEntry.Header header = entry.getHeader();
//            EntryType entryType = entry.getEntryType();
//
//            // 第二步：如果当前是RowData，那就是我需要的数据
//            if (entryType == EntryType.ROWDATA) {
//
//                String tableName = header.getTableName();
//                String schemaName = header.getSchemaName();
//
//                RowChange rowChange = null;
//
//                try {
//                    rowChange = RowChange.parseFrom(entry.getStoreValue());
//                } catch (InvalidProtocolBufferException e) {
//                    e.printStackTrace();
//                }
//
//                EventType eventType = rowChange.getEventType();
//
//                LOGGER.info(String.format("当前正在操作表 %s.%s， 执行操作= %s", schemaName, tableName, eventType));
//
//                // 如果是‘查询’ 或者 是 ‘DDL’ 操作，那么sql直接打出来
//                if (eventType == EventType.QUERY || rowChange.getIsDdl()) {
//                    LOGGER.info("执行了查询语句：[{}]", rowChange.getSql());
//                    return;
//                }
//
//                // 第三步：追踪到 columns 级别
//                rowChange.getRowDatasList().forEach((rowData) -> {
//
//                    // 获取更新之前的column情况
//                    List<Column> beforeColumns = rowData.getBeforeColumnsList();
//
//                    // 获取更新之后的 column 情况
//                    List<Column> afterColumns = rowData.getAfterColumnsList();
//
//                    // 当前执行的是 删除操作
//                    if (eventType == EventType.DELETE) {
//                        printColumn(beforeColumns);
//                    }
//
//                    // 当前执行的是 插入操作
//                    if (eventType == EventType.INSERT) {
//                        printColumn(afterColumns);
//                    }
//
//                    // 当前执行的是 更新操作
//                    if (eventType == EventType.UPDATE) {
//                        printColumn(afterColumns);
//                        // 进行删除缓存操作
//                        deleteCache(afterColumns, tableName, schemaName);
//                    }
//
//
//                });
//            }
//        }
//    }
//
//    /**
//     * 每个row上面的每一个column 的更改情况
//     *
//     * @param columns
//     */
//    public static void printColumn(List<Column> columns) {
//
//        columns.forEach((column) -> {
//            String columnName = column.getName();
//            String columnValue = column.getValue();
//            String columnType = column.getMysqlType();
//            // 判断 该字段是否更新
//            boolean isUpdated = column.getUpdated();
//            LOGGER.info(String.format("数据列：columnName=%s, columnValue=%s, columnType=%s, isUpdated=%s", columnName, columnValue, columnType, isUpdated));
//        });
//    }
//
//    /**
//     * 秒杀下单接口删除库存缓存
//     */
//    public static void deleteCache(List<Column> columns, String tableName, String schemaName) {
//        if ("stock".equals(tableName) && "m4a_miaosha".equals(schemaName)) {
//            AtomicInteger id = new AtomicInteger();
//            columns.forEach((column) -> {
//                String columnName = column.getName();
//                String columnValue = column.getValue();
//                if ("id".equals(columnName)) {
//                    id.set(Integer.parseInt(columnValue));
//                }
//            });
//            // TODO: 删除缓存
//            LOGGER.info("Canal删除stock表id：[{}] 的库存缓存", id);
//
//        }
//    }
//}
