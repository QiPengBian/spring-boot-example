package com.example.mq.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 初始化topic，设置partition分区，提升kafka效率
 * @author: bianqipeng
 * @date: 2021-02-20 13:41:48
 */
@Configuration
public class TopicInitConfig {

    @Bean
    public NewTopic initialTopic01() {
        return new NewTopic("topic01",8, (short) 1 );
    }

    @Bean
    public NewTopic initialTopic02() {
        return new NewTopic("topic02",12, (short) 1 );
    }

    @Bean
    public NewTopic initialTopic03() {
        return new NewTopic("topic03",16, (short) 1 );
    }

    @Bean
    public NewTopic initialTopic04() {
        return new NewTopic("topic04",16, (short) 1 );
    }
}
