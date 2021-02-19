package com.example;

import com.example.sys.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import javax.annotation.Resource;
import java.util.Set;

@SpringBootTest
class SetApplicationTests {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private final static String SET_KEY_001 = "set001";
    private final static String SET_KEY_002 = "set002";

    /**
     * @description: set类型测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:57:03
     */
    @Test
    void setAddTest() {
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        setOperations.add(SET_KEY_001, new User("张三", "123456"));
        setOperations.add(SET_KEY_001, new User("李四", "234567"));
        setOperations.add(SET_KEY_002, new User("张三", "123456"));
        setOperations.add(SET_KEY_002, new User("王五", "345678"));
    }

    /**
     * @description: set类型测试
     * @author: bianqipeng
     * @date: 2021-02-19 08:57:03
     */
    @Test
    void setPopTest() {
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        Long size = setOperations.size(SET_KEY_001);
        for (int i = 0; i < size; i++) {
            User user = (User) setOperations.pop(SET_KEY_001);
            System.out.println(user);
        }
    }

    /**
     * @description: 找不同元素
     * @author: bianqipeng
     * @date: 2021-02-19 13:33:19
     */
    @Test
    void setDifferenceTest() {
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        Set<Object> objectSet = setOperations.difference(SET_KEY_001, SET_KEY_002);
        objectSet.forEach(obj -> System.out.println((User) obj));
        objectSet = setOperations.difference(SET_KEY_002, SET_KEY_001);
        objectSet.forEach(obj -> System.out.println((User) obj));
    }

    /**
     * @description: 找相同元素
     * @author: bianqipeng
     * @date: 2021-02-19 14:02:07
     */
    @Test
    void setIntersectTest() {
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        Set<Object> objectSet = setOperations.intersect(SET_KEY_001, SET_KEY_002);
        objectSet.forEach(obj -> System.out.println((User) obj));
    }

    /**
     * @description: TODO
     * @author: bianqipeng
     * @date: 2021-02-19 14:42:08
     */
    @Test
    void setMembersTest() {
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        Set<Object> objectSet = setOperations.members(SET_KEY_001);
        objectSet.forEach(obj -> System.out.println((User) obj));
    }
}
