package com.example;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.example.sys.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: Redis Hash类型测试
 * @author: bianqipeng
 * @date: 2021-02-19 10:03:27
 */
@SpringBootTest
class HashApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private final static String HASH_KEY = "hash001";

    /**
     * @description: hash类型put测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:54:20
     */
    @Test
    void hashPutAllTest() {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(HASH_KEY, BeanUtil.beanToMap(new User("张三", "123456")));
    }

    /**
     * @description: hash类型get测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:54:20
     */
    @Test
    void hashGetTest() {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        System.out.println(hashOperations.get(HASH_KEY, User.USERNAME));
    }

    /**
     * @description: 查询整个map数据
     * @author: bianqipeng
     * @date: 2021-02-19 11:19:58
     */
    @Test
    void hashEntriesTest() {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        Map<Object, Object> objectMap = hashOperations.entries(HASH_KEY);
        User user = BeanUtil.mapToBean(objectMap, User.class, false);
        System.out.println(user);
        JSON json = JSONUtil.parse(objectMap);
        user = JSONUtil.toBean(json, User.class, false);
        System.out.println(user);
    }

    /**
     * @description: 更新数据
     * @author: bianqipeng
     * @date: 2021-02-19 11:24:22
     */
    @Test
    void hashPutTest() {
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        hashOperations.put(HASH_KEY, User.USERNAME, "李四");
    }

}
