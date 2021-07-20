//package com.example;
//
//
//import com.alibaba.otter.canal.client.CanalConnector;
//import com.alibaba.otter.canal.client.CanalConnectors;
//import com.alibaba.otter.canal.protocol.CanalEntry;
//import com.alibaba.otter.canal.protocol.Message;
//import com.example.sys.service.UserService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.net.InetSocketAddress;
//import java.util.List;
//
//@SpringBootTest
//class SpringBoot13CanalApplicationTests {
//
//    @Autowired
//    private UserService userService;
//
//    /**
//     * @description: TODO
//     * @author: bianqipeng
//     * @date: 2021-07-08 10:18:06
//     */
//    @Test
//    void contextLoads() {
//        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("192.168.11.130",
//                11111), "example", "", "");
//        try {
//            connector.connect();
//            //监听的表，    格式为数据库.表名,数据库.表名
//            connector.subscribe(".*\\..*");
//            connector.rollback();
//
//            while (true) {
//                Message message = connector.getWithoutAck(100); // 获取指定数量的数据
//                long batchId = message.getId();
//                if (batchId == -1 || message.getEntries().isEmpty()) {
//                    Thread.sleep(1000);
//                    continue;
//                }
//                // System.out.println(message.getEntries());
//                printEntries(message.getEntries());
//                connector.ack(batchId);// 提交确认，消费成功，通知server删除数据
//                // connector.rollback(batchId);// 处理失败, 回滚数据，后续重新获取数据
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            connector.disconnect();
//        }
//    }
//
//    private static void printEntries(List<CanalEntry.Entry> entries) throws Exception {
//        for (CanalEntry.Entry entry : entries) {
//            if (entry.getEntryType() != CanalEntry.EntryType.ROWDATA) {
//                continue;
//            }
//
//            CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
//
//            CanalEntry.EventType eventType = rowChange.getEventType();
//            System.out.println(String.format("================> binlog[%s:%s] , name[%s,%s] , eventType : %s",
//                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
//                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(), eventType));
//
//            for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
//                switch (rowChange.getEventType()) {
//                    case INSERT:
//                        System.out.println("INSERT ");
//                        printColumns(rowData.getAfterColumnsList());
//                        break;
//                    case UPDATE:
//                        System.out.println("UPDATE ");
//                        printColumns(rowData.getAfterColumnsList());
//                        break;
//                    case DELETE:
//                        System.out.println("DELETE ");
//                        printColumns(rowData.getBeforeColumnsList());
//                        break;
//
//                    default:
//                        break;
//                }
//            }
//        }
//    }
//
//    private static void printColumns(List<CanalEntry.Column> columns) {
//        for (CanalEntry.Column column : columns) {
//            System.out.println(column.getName() + " : " + column.getValue() + " update=" + column.getUpdated());
//        }
//    }
//
//}
