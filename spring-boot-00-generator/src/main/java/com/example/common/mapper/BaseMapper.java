package com.example.common.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.additional.update.force.UpdateByPrimaryKeySelectiveForceProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @description: mapper基础类
 * @author: bianqipeng
 * @date: 2020年05月26日 13:32:32
 */
@RegisterMapper
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {


    /**
     * @description: 自定义字段，允许将数据修改成null
     * @author: bianqipeng
     * @date: 2020年06月18日 15:21:45
     * @param: record
     * @param: forceUpdateProperties
     * @return: int
     */
    @UpdateProvider(type = UpdateByPrimaryKeySelectiveForceProvider.class, method = "dynamicSQL")
    int updateByPrimaryKeySelectiveForce(@Param(value = "record") T record,
                                         @Param(value = "forceUpdateProperties") List<String> forceUpdateProperties);
}
