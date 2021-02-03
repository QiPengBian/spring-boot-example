package com.example;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sys.domain.RoleEntity;
import com.example.sys.domain.UserEntity;
import com.example.sys.service.RoleService;
import com.example.sys.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot04DataMybatisPlusApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

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

    @Test
    void roleListTest() {
        RoleEntity roleEntity = roleService.queryModelByPrimaryKey(1);
        System.out.println(roleEntity);
    }

    @Test
    void rolePageTest() {
        Page<RoleEntity> page = new Page<>(1, 1);
        RoleEntity roleEntity = RoleEntity.builder()
//                .id(1L)
                .build();
        IPage<RoleEntity> roleEntityIPage = roleService.queryPageByModel(page, roleEntity);
        System.out.println(JSONUtil.parse(roleEntityIPage));
    }
}
