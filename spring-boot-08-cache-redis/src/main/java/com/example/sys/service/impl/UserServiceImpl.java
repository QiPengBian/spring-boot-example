package com.example.sys.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sys.domain.User;
import com.example.sys.mapper.UserMapper;
import com.example.sys.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-02-05 17:31:14
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     * @description: 新增用户
     * @author: bianqipeng
     * @date: 2021-01-05 16:21:07
     * @param: userEntity
     */
    @Override
    @CachePut(key = "#user.username")
    public User saveUser(User user) {
        if (ObjectUtil.isNotNull(user)) {
            baseMapper.insert(user);
        }
        return user;
    }

    /**
     * @description: 修改用户
     * @author: bianqipeng
     * @date: 2021-01-06 11:28:41
     * @param: userEntity
     * @return: UserEntity
     */
    @Override
    @CachePut(key = "#user.username")
    public User updateUser(User user) {
        if (ObjectUtil.isNotNull(user)) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(User.USERNAME, user.getUsername());
            baseMapper.update(user, queryWrapper);
        }
        return user;
    }

    /**
     * @description: 删除用户
     * @author: bianqipeng
     * @date: 2021-01-05 16:33:37
     * @param: username
     */
    @Override
    @CacheEvict(key = "#username")
    public void deleteUserByUsername(String username) {
        if (StrUtil.isNotBlank(username)) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(User.USERNAME, username);
            baseMapper.delete(queryWrapper);
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
    @Cacheable(key = "#username")
    public User queryUserByUsename(String username) {
        User user = null;
        if (StrUtil.isNotBlank(username)) {
            List<User> userList = baseMapper.queryUserByUsername(username);
            if (CollectionUtil.isNotEmpty(userList)) {
                user = userList.get(0);
            }
        }
        return user;
    }

    /**
     * @description: 通过角色查询用户
     * @author: bianqipeng
     * @date: 2021-02-07 09:52:27
     * @param: roleName
     * @return: List<User>
     */
    @Override
    public List<User> queryUserByRoleName(String roleName) {
        List<User> userList = null;
        if (StrUtil.isNotBlank(roleName)) {
            userList = baseMapper.queryUserByRoleName(roleName);
        }
        return userList;
    }
}