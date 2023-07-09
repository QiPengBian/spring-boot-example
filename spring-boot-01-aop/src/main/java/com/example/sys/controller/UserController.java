package com.example.sys.controller;

import com.example.common.domain.Resp;
import com.example.sys.domain.UserEntity;
import com.example.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-05 15:16:56
 */
@RestController
@RequestMapping("sys/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @description: 新增用户
     * @author: bianqipeng
     * @date: 2021-01-06 11:46:54
     * @param: userEntity
     * @return: Resp
     */
    @PostMapping("/addUser")
    public Resp addUser(UserEntity userEntity) {
        userService.saveUser(userEntity);
        return Resp.ok();
    }

    /**
     * @description: 更新用户
     * @author: bianqipeng
     * @date: 2021-01-06 11:46:58
     * @param: userEntity
     * @return: Resp
     */
    @PostMapping("/updateUser")
    public Resp updateUser(UserEntity userEntity) {
        userService.updateUser(userEntity);
        return Resp.ok();
    }

    /**
     * @description: 查询用户
     * @author: bianqipeng
     * @date: 2021-01-06 08:52:36
     * @param: username
     * @return: Resp<UserEntity>
     */
    @GetMapping("/queryUserByUsername")
    public Resp<UserEntity> queryUserByUsename(String username) {
        UserEntity userEntity = userService.queryUserByUsename(username);
        return Resp.ok(userEntity);
    }
}
