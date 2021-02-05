package com.example.sys.service;


import com.example.sys.domain.Role;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description: 角色信息表
 * @author: QiPeng
 * @date: 2021-02-05 13:52:05
 */
public interface RoleService {

    /**
     * @description: 新增数据
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: role
     */
    void saveSelective(Role role);

    /**
     * @description: 通过主键更新数据
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: role
     */
    void updateByPrimaryKeySelective(Role role);

    /**
     * @description: 通过example更新数据
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: role
     * @param: example
     */
    void updateByExampleSelective(Role role, Example example);

    /**
     * @description: 通过主键更新数据（可以将指定字段更新为null）
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: role
     * @param: fieldList
     */
    void updateByPrimaryKeySelectiveForce(Role role, List<String> fieldList);

    /**
     * @description: 分页查询
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: page
     * @param: example
     * @return: PageInfo<Role>
     */
    PageInfo<Role> queryPage(PageInfo page, Example example);

    /**
     * @description: example查询
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: example
     * @return: List<Role>
     */
    List<Role> queryListByExample(Example example);

    /**
     * @description: 主键查询
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: id
     * @return: Role
     */
    Role queryByPrimaryKey(Long id);

    /**
     * @description: 主键删除
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: id
     */
    void deleteByPrimaryKey(Long id);

}

