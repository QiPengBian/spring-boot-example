package com.example.sys.controller;

import com.example.common.domain.Resp;
import com.example.sys.domain.User;
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
 * @date 2021-02-05 17:31:14
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
     * @param: user
     * @return: Resp
     */
    @PostMapping("/addUser")
    public Resp addUser(User user) {
        userService.saveUser(user);
        return Resp.ok();
    }

    /**
     * @description: 更新用户
     * @author: bianqipeng
     * @date: 2021-01-06 11:46:58
     * @param: user
     * @return: Resp
     */
    @PostMapping("/updateUser")
    public Resp updateUser(User user) {
        userService.updateUser(user);
        return Resp.ok();
    }

    /**
     * @description: 删除用户
     * @author: bianqipeng
     * @date: 2021-01-05 16:33:24
     * @param: username
     * @return: Resp
     */
    @GetMapping("/deleteUserByUsername")
    public Resp deleteUserByUsername(String username) {
        userService.deleteUserByUsername(username);
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
    public Resp<User> queryUserByUsename(String username) {
        User user = userService.queryUserByUsename(username);
        return Resp.ok(user);
    }
}
