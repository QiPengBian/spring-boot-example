package com.example.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sys.domain.Role;
import com.example.sys.domain.User;
import com.example.sys.mapper.RoleMapper;
import com.example.sys.service.RoleService;
import com.example.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-12 13:24:51
 */
@Service
@CacheConfig(cacheNames = "role")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private UserService userService;

    /**
     * @description: 通过角色查询用户
     * @author: bianqipeng
     * @date: 2021-02-07 09:52:27
     * @param: roleName
     * @return: List<User>
     */
    @Override
    @Cacheable
    public List<User> queryUserByRoleName(String roleName) {
        return userService.queryUserByRoleName(roleName);
    }
}