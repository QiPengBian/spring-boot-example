package com.example.sys.mapper;

import com.example.common.mapper.BaseMapper;
import com.example.sys.domain.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 角色信息表
 * @author: QiPeng
 * @date: 2021-02-05 13:52:05
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
