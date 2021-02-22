package com.example.sys.controller;

import com.example.mq.kafka.handler.KafkaSendResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-02-19 17:23:28
 */
@RestController
@RequestMapping("sys/user")
public class UserController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaSendResultHandler kafkaSendResultHandler;

    @GetMapping("/topic01")
    public String topic01(String message) {
        kafkaTemplate.send("topic01", message);
        return message;
    }

    @GetMapping("/topic02")
    public String topic02(String message) {
        kafkaTemplate.send("topic02", message);
        return message;
    }

    @GetMapping("/topic03")
    public String topic03(String message) {
        kafkaTemplate.send("topic03", message);
        return message;
    }

    @GetMapping("/topic04")
    public String topic04(String message) {
        // 结果回调
        kafkaTemplate.setProducerListener(kafkaSendResultHandler);
        kafkaTemplate.send("topic04", message);
        return message;
    }
}
