package com.example.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.common.annotation.AopLog;
import com.example.sys.domain.UserEntity;
import com.example.sys.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-05 15:16:56
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * @description: 新增用户
     * @author: bianqipeng
     * @date: 2021-01-05 16:21:07
     * @param: userEntity
     */
    @AopLog(title = "新增用户")
    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        if (ObjectUtil.isNotNull(userEntity)) {
            userEntity.setId(1L);
        }
        return userEntity;
    }

    /**
     * @description: 修改用户
     * @author: bianqipeng
     * @date: 2021-01-06 11:28:41
     * @param: userEntity
     * @return: UserEntity
     */
    @AopLog(title = "修改用户")
    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        if (ObjectUtil.isNotNull(userEntity)) {
            String username = userEntity.getUsername();
            switch (username) {
                case "zhangsan":
                    username = "lisi";
                    break;
                case "lisi":
                    username = "zhangsan";
                    break;
                default:
            }
            userEntity.setUsername(username);
        }
        return userEntity;
    }

    /**
     * @description: 查询用户
     * @author: bianqipeng
     * @date: 2021-01-06 08:52:49
     * @param: username
     * @return: UserEntity
     */
    @AopLog(title = "通过用户名查询用户")
    @Override
    public UserEntity queryUserByUsename(String username) {
        UserEntity userEntity = null;
        if (StrUtil.isNotBlank(username)) {
            switch (username) {
                case "zhangsan":
                    userEntity = UserEntity.builder().id(1L).username("zhangsan").password("123456").build();
                    break;
                case "lisi":
                    userEntity = UserEntity.builder().id(2L).username("lisi").password("123456").build();
                    break;
                default:
            }
        }
        return userEntity;
    }
}