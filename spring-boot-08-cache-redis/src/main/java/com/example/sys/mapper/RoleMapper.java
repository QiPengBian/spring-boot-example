package com.example.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sys.domain.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色信息表
 * 
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-12 13:24:51
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
	
}
