package com.example.sys.controller;

import com.example.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-07-07 14:21:17
 */
@RestController("sys/user")
public class UserController {

    @Autowired
    private UserService userService;

}
