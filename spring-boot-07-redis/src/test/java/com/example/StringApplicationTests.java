package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * @description: Redis String类型测试
 * @author: bianqipeng
 * @date: 2021-02-19 10:03:10
 */
@SpringBootTest
class StringApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private final static String STR_KEY = "str_001";
    private final static String STR_INCREMENT_KEY = "str_incerment_001";

    /**
     * @description: String类型保存测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:53:28
     */
    @Test
    void stringSaveTest() {
        ValueOperations<String, Object> stringOperations = redisTemplate.opsForValue();
        stringOperations.set(STR_KEY, "上班摸鱼");
    }

    /**
     * @description: String类型自增测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:53:28
     */
    @Test
    void stringIncrementTest() {
        ValueOperations<String, Object> stringOperations = redisTemplate.opsForValue();
        stringOperations.increment(STR_INCREMENT_KEY, 1);
        for (int i = 0; i < 100; i++) {
            stringOperations.increment(STR_INCREMENT_KEY);
        }
        System.out.println(stringOperations.get(STR_INCREMENT_KEY));
    }

    /**
     * @description: String类型查询测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:53:28
     */
    @Test
    void stringGetTest() {
        ValueOperations<String, Object> stringOperations = redisTemplate.opsForValue();
        System.out.println(stringOperations.get(STR_KEY));
    }

}
