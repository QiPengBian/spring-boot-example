package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
class SpringBoot10MqKafkaApplicationTests {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Test
    void contextLoads() {
        kafkaTemplate.send("topic01","HelloWorld");
    }

}
