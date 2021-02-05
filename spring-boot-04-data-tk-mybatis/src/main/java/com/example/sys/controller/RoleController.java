package com.example.sys.controller;

import com.example.sys.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 角色信息表
 * @author: QiPeng
 * @date: 2021-02-05 13:52:05
 */
@Slf4j
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

}
