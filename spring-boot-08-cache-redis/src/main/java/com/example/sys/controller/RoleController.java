package com.example.sys.controller;

import com.example.common.domain.Resp;
import com.example.sys.domain.User;
import com.example.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-02-05 17:31:14
 */
@RestController
@RequestMapping("sys/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * @description: 通过角色查询用户
     * @author: bianqipeng
     * @date: 2021-02-07 09:53:35
     * @param: roleName
     * @return: Resp<List < User>>
     */
    @GetMapping("/queryUserByRoleName")
    public Resp<List<User>> queryUserByRoleName(String roleName) {
        List<User> userList = roleService.queryUserByRoleName(roleName);
        return Resp.ok(userList);
    }

}
