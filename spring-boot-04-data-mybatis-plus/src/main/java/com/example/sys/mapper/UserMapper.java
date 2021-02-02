package com.example.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sys.domain.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-05 15:16:56
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * @description: 用户：角色=1：n
     * @author: bianqipeng
     * @date: 2021-01-12 14:23:01
     * @param: username
     * @return: UserEntity
     */
    List<UserEntity> queryUserByUsername(@Param("username") String username);

    List<UserEntity> queryUserByRoleName(String roleName);
}
