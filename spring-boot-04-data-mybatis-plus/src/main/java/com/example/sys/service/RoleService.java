package com.example.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sys.domain.RoleEntity;

import java.util.List;

/**
 * 角色信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-12 13:24:51
 */
public interface RoleService extends IService<RoleEntity> {

    /**
     * @description: 分页查询
     * @author: bianqipeng
     * @date: 2021-02-03 09:54:41
     * @param: page
     * @param: roleEntity
     * @return: IPage<RoleEntity>
     */
    IPage<RoleEntity> queryPageByModel(Page page, RoleEntity roleEntity);

    /**
     * @description: 新增数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:20
     * @param: roleEntity
     */
    void saveModel(RoleEntity roleEntity);

    /**
     * @description: 通过主键更新数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:23
     * @param: roleEntity
     */
    void updateModelByPrimaryKey(RoleEntity roleEntity);

    /**
     * @description: 通过Wrapper更新数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:26
     * @param: roleEntity
     * @param: queryWrapper
     */
    void updateModelByWrapper(RoleEntity roleEntity, QueryWrapper<RoleEntity> queryWrapper);

    /**
     * @description: 通过主键查询数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:30
     * @param: id
     * @return: RoleEntity
     */
    RoleEntity queryModelByPrimaryKey(Integer id);

    /**
     * @description: 通过Wrapper查询数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:33
     * @param: queryWrapper
     * @return: List<RoleEntity>
     */
    List<RoleEntity> queryModelByWrapper(QueryWrapper<RoleEntity> queryWrapper);

}

