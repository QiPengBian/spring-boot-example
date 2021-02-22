package com.example.mq.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @description: kafka消费者测试
 * 通过将topic分配给不同的group,从而实现发布订阅模式
 * @author: bianqipeng
 * @date: 2021-02-19 17:20:25
 */
@Component
public class KafkaConsumer {

    /**
     * @description: TODO
     * @author: bianqipeng
     * @date: 2021-02-20 11:21:33
     * @param: message
     */
    @KafkaListener(topics = {"topic01", "topic02"}, groupId = "topic01_group")
    public void receiveMessage01(String message) {
        //收到通道的消息之后执行秒杀操作
        System.out.println("Group:topic01_group,message：" + message);
    }

    /**
     * @description: TODO
     * @author: bianqipeng
     * @date: 2021-02-20 11:21:37
     * @param: message
     */
    @KafkaListener(topics = {"topic02", "topic03"}, groupId = "topic02_group")
    public void receiveMessage02(String message) {
        //收到通道的消息之后执行秒杀操作
        System.out.println("Group:topic02_group,message：" + message);
    }

    /**
     * @description: TODO
     * @author: bianqipeng
     * @date: 2021-02-20 11:21:40
     * @param: message
     */
    @KafkaListener(topics = {"topic01", "topic03"}, groupId = "topic03_group")
    public void receiveMessage03(String message) {
        //收到通道的消息之后执行秒杀操作
        System.out.println("Group:topic03_group,message：" + message);
    }

    /**
     * @description: 手动提交offset
     * @author: bianqipeng
     * @date: 2021-02-22 10:24:19
     * @param: record
     * @param: acknowledgment
     */
    @KafkaListener(topics = {"topic04"})
    public void receiveMessage04(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("Group:topic03_group,message：" + message);
        }
        // 手动提交
        acknowledgment.acknowledge();
    }
}
