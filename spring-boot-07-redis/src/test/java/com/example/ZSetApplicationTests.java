package com.example;

import com.example.sys.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @description: zset得分可以用来做数据排名
 * @author: bianqipeng
 * @date: 2021-02-19 15:20:58
 */
@SpringBootTest
class ZSetApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private final static String ZSET_KEY = "zset001";

    /**
     * @description: zset类型测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:57:05
     */
    @Test
    void zSetTest() {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(ZSET_KEY, new User("张三", "123456"), 1);
        zSetOperations.add(ZSET_KEY, new User("李四", "234567"), 3);
        zSetOperations.add(ZSET_KEY, new User("王五", "345678"), 2);
        zSetOperations.add(ZSET_KEY, new User("赵六", "456789"), 4);
    }

    /**
     * @description: 获取得分最低的数据
     * @author: bianqipeng
     * @date: 2021-02-19 15:08:41
     */
    @Test
    void zSetRangeByScoreWithScoresTest() {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> typedTuples = zSetOperations.rangeWithScores(ZSET_KEY, 0, 0);
        typedTuples.forEach(objectTypedTuple -> System.out.println((User) objectTypedTuple.getValue()));
    }

    /**
     * @description: 获取得分最高的数据
     * @author: bianqipeng
     * @date: 2021-02-19 15:08:41
     */
    @Test
    void zSetReverseRangeByScoresTest() {
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        Set<ZSetOperations.TypedTuple<Object>> typedTuples = zSetOperations.reverseRangeWithScores(ZSET_KEY, 0, 0);
        typedTuples.forEach(objectTypedTuple -> System.out.println((User) objectTypedTuple.getValue()));
    }

}
