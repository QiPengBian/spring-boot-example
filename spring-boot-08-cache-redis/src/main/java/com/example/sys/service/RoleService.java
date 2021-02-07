package com.example.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sys.domain.Role;
import com.example.sys.domain.User;

import java.util.List;

/**
 * 角色信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-12 13:24:51
 */
public interface RoleService extends IService<Role> {

    /**
     * @description: 通过角色查询用户
     * @author: bianqipeng
     * @date: 2021-02-07 09:52:27
     * @param: roleName
     * @return: List<User>
     */
    List<User> queryUserByRoleName(String roleName);
}

