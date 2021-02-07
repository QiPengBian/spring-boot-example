package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringBoot07RedisApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private final static String STR_KEY = "str001";

    @Test
    void strTest() {
        redisTemplate.opsForValue().set(STR_KEY, "上班摸鱼");
        System.out.println(redisTemplate.opsForValue().get(STR_KEY));
    }

}
