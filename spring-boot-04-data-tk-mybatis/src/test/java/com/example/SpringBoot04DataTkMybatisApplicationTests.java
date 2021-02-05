package com.example;

import cn.hutool.core.collection.CollectionUtil;
import com.example.sys.domain.Role;
import com.example.sys.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@SpringBootTest
class SpringBoot04DataTkMybatisApplicationTests {

    @Autowired
    private RoleService roleService;

    @Test
    void saveSelectiveTest() {
        Role role = Role.builder()
                .roleName("ROLE_LOOK")
                .build();
        roleService.saveSelective(role);
        List<Role> roleList = roleService.queryListByExample(new Example(Role.class));
        if (CollectionUtil.isNotEmpty(roleList)) {
            roleList.forEach(System.out::println);
        }
    }

    @Test
    void updateByPrimaryKeySelectiveTest() {
        Role role = Role.builder()
                .id(6L)
                .roleName("ROLE_LOOK001")
                .build();
        roleService.updateByPrimaryKeySelective(role);
        List<Role> roleList = roleService.queryListByExample(new Example(Role.class));
        if (CollectionUtil.isNotEmpty(roleList)) {
            roleList.forEach(System.out::println);
        }
    }

    @Test
    void queryPageTest() {
        PageInfo<Role> page = new PageInfo<>();
        page.setPageNum(2);
        page.setPageSize(2);
        PageInfo<Role> pageInfo = roleService.queryPage(page, new Example(Role.class));
        pageInfo.getList().forEach(System.out::println);
    }

    @Test
    void queryByPrimaryKeyTest() {
        System.out.println(roleService.queryByPrimaryKey(1L));
    }
}
