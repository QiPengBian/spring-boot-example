package com.example.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sys.domain.User;

import java.util.List;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-02-05 17:31:14
 */
public interface UserService extends IService<User> {

    /**
     * @description: 新增用户
     * @author: bianqipeng
     * @date: 2021-01-05 16:21:07
     * @param: userEntity
     */
    User saveUser(User user);

    /**
     * @description: 修改用户
     * @author: bianqipeng
     * @date: 2021-01-06 11:28:41
     * @param: userEntity
     * @return: UserEntity
     */
    User updateUser(User user);

    /**
     * @description: 删除用户
     * @author: bianqipeng
     * @date: 2021-01-05 16:33:37
     * @param: username
     */
    void deleteUserByUsername(String username);

    /**
     * @description: 查询用户
     * @author: bianqipeng
     * @date: 2021-01-06 08:52:49
     * @param: username
     * @return: UserEntity
     */
    User queryUserByUsename(String username);

    /**
     * @description: 通过角色查询用户
     * @author: bianqipeng
     * @date: 2021-02-07 09:52:27
     * @param: roleName
     * @return: List<User>
     */
    List<User> queryUserByRoleName(String roleName);
}

