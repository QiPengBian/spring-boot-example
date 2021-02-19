package com.example;

import cn.hutool.json.JSONUtil;
import com.example.sys.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @description: List测试案例
 * @author: bianqipeng
 * @date: 2021-02-19 10:05:21
 */
@SpringBootTest
class ListApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private final static String LIST_KEY_001 = "list001";
    private final static String LIST_KEY_002 = "list002";

    /**
     * @description: list类型all保存测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:57:00
     */
    @Test
    void listPushAllTest() {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        listOperations.leftPushAll(
                LIST_KEY_001,
                new User("张三", "123456"),
                new User("李四", "234567")
        );
    }

    /**
     * @description: list类型left保存测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:57:00
     */
    @Test
    void listLeftPushTest() {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        listOperations.leftPush(LIST_KEY_001, new User("wangwu", "345678"));
    }

    /**
     * @description: list类型right保存测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:57:00
     */
    @Test
    void listRightPushTest() {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        listOperations.rightPush(LIST_KEY_001, new User("zhaoliu", "456789"));
    }

    /**
     * @description: list类型查询测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:57:00
     */
    @Test
    void listLeftPopTest() {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        Object obj = listOperations.leftPop(LIST_KEY_001);
        System.out.println(JSONUtil.parse(obj));
    }

    /**
     * @description: list类型查询测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:57:00
     */
    @Test
    void listRightPopTest() {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        Object obj = listOperations.rightPop(LIST_KEY_001);
        System.out.println(JSONUtil.parse(obj));
    }

    /**
     * @description: TODO
     * @author: bianqipeng
     * @date: 2021-02-19 09:54:41
     */
    @Test
    void listRightPopAndLeftPush() {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
        Object obj = listOperations.rightPopAndLeftPush(LIST_KEY_001, LIST_KEY_002, 30, TimeUnit.SECONDS);
        System.out.println(JSONUtil.parse(obj));
    }

}
