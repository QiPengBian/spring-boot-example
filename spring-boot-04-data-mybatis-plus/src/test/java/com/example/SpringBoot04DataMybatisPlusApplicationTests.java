package com.example;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sys.domain.Role;
import com.example.sys.domain.User;
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

    /**
     * @description: 一对多测试
     * @author: bianqipeng
     * @date: 2021-02-04 15:52:32
     */
    @Test
    void oneToManyTest() {
        User user = userService.queryUserByUsename("zhangsan");
        System.out.println(JSONUtil.toJsonStr(user));
    }

    /**
     * @description: 多对多测试
     * @author: bianqipeng
     * @date: 2021-02-04 16:01:29
     */
    @Test
    void manyToManyTest() {
        List<User> userList = userService.queryUserByRoleName("ROLE_READ");
        userList.forEach(System.out::println);
    }

    /**
     * @description: 列表查询测试
     * @author: bianqipeng
     * @date: 2021-02-04 16:01:34
     */
    @Test
    void roleListTest() {
        Role role = roleService.queryModelByPrimaryKey(1);
        System.out.println(role);
    }

    /**
     * @description: TODO
     * @author: bianqipeng
     * @date: 2021-02-04 16:01:38
     */
    @Test
    void rolePageTest() {
        Page<Role> page = new Page<>(2, 2);
        Role role = Role.builder()
                .build();
        IPage<Role> roleIPage = roleService.queryPageByModel(page, role);
        System.out.println(JSONUtil.parse(roleIPage));
    }
}
