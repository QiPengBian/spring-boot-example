package com.example.sys.mapper;

import com.example.common.mapper.BaseMapper;
import com.example.sys.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 用户信息表
 * @author: QiPeng
 * @date: 2021-02-05 16:01:56
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
	
}
