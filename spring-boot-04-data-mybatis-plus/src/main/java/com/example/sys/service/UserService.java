package com.example.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sys.domain.User;

import java.util.List;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-05 15:16:56
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
     * @description: 通过角色名称查询用户
     * @author: bianqipeng
     * @date: 2021-01-12 15:36:54
     * @param: roleName
     * @return: List<UserEntity>
     */
    List<User> queryUserByRoleName(String roleName);
}

