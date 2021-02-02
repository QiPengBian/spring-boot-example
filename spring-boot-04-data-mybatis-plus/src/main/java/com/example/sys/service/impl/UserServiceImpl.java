package com.example.sys.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sys.domain.UserEntity;
import com.example.sys.mapper.UserMapper;
import com.example.sys.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-05 15:16:56
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    /**
     * @description: 新增用户
     * @author: bianqipeng
     * @date: 2021-01-05 16:21:07
     * @param: userEntity
     */
    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        if (ObjectUtil.isNotNull(userEntity)) {
            this.save(userEntity);
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
    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        if (ObjectUtil.isNotNull(userEntity)) {
            QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(UserEntity.USERNAME, userEntity.getUsername());
            this.update(userEntity, queryWrapper);
        }
        return userEntity;
    }

    /**
     * @description: 删除用户
     * @author: bianqipeng
     * @date: 2021-01-05 16:33:37
     * @param: username
     */
    @Override
    public void deleteUserByUsername(String username) {
        if (StrUtil.isNotBlank(username)) {
            QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(UserEntity.USERNAME, username);
            this.remove(queryWrapper);
        }
    }

    /**
     * @description: 查询用户
     * @author: bianqipeng
     * @date: 2021-01-06 08:52:49
     * @param: username
     * @return: UserEntity
     */
    @Override
    public UserEntity queryUserByUsename(String username) {
        UserEntity userEntity = null;
        if (StrUtil.isNotBlank(username)) {
            List<UserEntity> userEntityList = this.baseMapper.queryUserByUsername(username);
            if (CollectionUtil.isNotEmpty(userEntityList)) {
                userEntity = userEntityList.get(0);
            }
        }
        return userEntity;
    }

    @Override
    public List<UserEntity> queryUserByRoleName(String roleName) {
        List<UserEntity> userEntityList = null;
        if (StrUtil.isNotBlank(roleName)) {
            userEntityList = this.baseMapper.queryUserByRoleName(roleName);
        }
        return userEntityList;
    }
}