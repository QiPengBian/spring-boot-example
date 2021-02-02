package com.example.sys.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.sys.mapper.RoleMapper;
import com.example.sys.domain.RoleEntity;
import com.example.sys.service.RoleService;

/**
 * 角色信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-12 13:24:51
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

}