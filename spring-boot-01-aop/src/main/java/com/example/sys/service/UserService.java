package com.example.sys.service;

import com.example.sys.domain.UserEntity;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-05 15:16:56
 */
public interface UserService {

    /**
     * @description: 新增用户
     * @author: bianqipeng
     * @date: 2021-01-05 16:21:07
     * @param: userEntity
     */
    UserEntity saveUser(UserEntity userEntity);

    /**
     * @description: 修改用户
     * @author: bianqipeng
     * @date: 2021-01-06 11:28:41
     * @param: userEntity
     * @return: UserEntity
     */
    UserEntity updateUser(UserEntity userEntity);

    /**
     * @description: 查询用户
     * @author: bianqipeng
     * @date: 2021-01-06 08:52:49
     * @param: username
     * @return: UserEntity
     */
    UserEntity queryUserByUsename(String username);
}

