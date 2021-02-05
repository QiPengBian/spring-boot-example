package com.example.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sys.domain.Role;

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
     * @description: 分页查询
     * @author: bianqipeng
     * @date: 2021-02-03 09:54:41
     * @param: page
     * @param: role
     * @return: IPage<role>
     */
    IPage<Role> queryPageByModel(Page page, Role role);

    /**
     * @description: 新增数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:20
     * @param: role
     */
    void saveModel(Role role);

    /**
     * @description: 通过主键更新数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:23
     * @param: role
     */
    void updateModelByPrimaryKey(Role role);

    /**
     * @description: 通过Wrapper更新数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:26
     * @param: role
     * @param: queryWrapper
     */
    void updateModelByWrapper(Role role, QueryWrapper<Role> queryWrapper);

    /**
     * @description: 通过主键查询数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:30
     * @param: id
     * @return: role
     */
    Role queryModelByPrimaryKey(Integer id);

    /**
     * @description: 通过Wrapper查询数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:33
     * @param: queryWrapper
     * @return: List<role>
     */
    List<Role> queryModelByWrapper(QueryWrapper<Role> queryWrapper);

}

