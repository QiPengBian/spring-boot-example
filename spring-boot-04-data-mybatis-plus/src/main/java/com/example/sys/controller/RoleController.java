package com.example.sys.controller;

import com.example.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-12 13:24:51
 */
@RestController("sys/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

}
