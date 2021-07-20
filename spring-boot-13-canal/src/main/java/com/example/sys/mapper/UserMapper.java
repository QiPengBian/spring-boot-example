package com.example.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sys.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表
 * 
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-07-07 14:21:17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
	
}
