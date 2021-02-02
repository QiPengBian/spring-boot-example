package com.example;

import cn.hutool.json.JSONUtil;
import com.example.sys.domain.UserEntity;
import com.example.sys.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot04DataMybatisPlusApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void oneToManyTest() {
        UserEntity userEntity = userService.queryUserByUsename("zhangsan");
        System.out.println(JSONUtil.toJsonStr(userEntity));
    }

    @Test
    void manyToManyTest() {
        List<UserEntity> userEntityList = userService.queryUserByRoleName("ROLE_READ");
        userEntityList.forEach(System.out::println);
    }

}
