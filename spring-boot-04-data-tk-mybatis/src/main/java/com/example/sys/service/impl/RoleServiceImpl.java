package com.example.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.sys.domain.Role;
import com.example.sys.mapper.RoleMapper;
import com.example.sys.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 角色信息表
 * @author: QiPeng
 * @date: 2021-02-05 13:52:05
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * @description: 新增数据
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: role
     */
    @Override
    public void saveSelective(Role role) {
        if (ObjectUtil.isNotNull(role)) {
            roleMapper.insertSelective(role);
        }
    }

    /**
     * @description: 通过主键更新数据
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: role
     */
    @Override
    public void updateByPrimaryKeySelective(Role role) {
        if (ObjectUtil.isNull(role) || ObjectUtil.isNull(role.getId())) {
            return;
        }
        roleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * @description: 通过example更新数据
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: role
     * @param: example
     */
    @Override
    public void updateByExampleSelective(Role role, Example example) {
        if (ObjectUtil.isNull(role) || ObjectUtil.isNull(example)) {
            return;
        }
        roleMapper.updateByExampleSelective(role, roleMapper);
    }

    /**
     * @description: 通过主键更新数据（可以将指定字段更新为null）
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: role
     * @param: fieldList
     */
    @Override
    public void updateByPrimaryKeySelectiveForce(Role role, List<String> fieldList) {
        if (ObjectUtil.isNull(role) || ObjectUtil.isNull(role.getId())) {
            return;
        }
        if (ObjectUtil.isNull(fieldList)) {
            fieldList = new ArrayList<>();
        }
        roleMapper.updateByPrimaryKeySelectiveForce(role, fieldList);
    }

    /**
     * @description: 分页查询
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: page
     * @param: example
     * @return: PageInfo<Role>
     */
    @Override
    public PageInfo<Role> queryPage(PageInfo page, Example example) {
        if (ObjectUtil.isNull(page) || ObjectUtil.isNull(example)) {
            return page;
        }
        //分页查询
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        page = new PageInfo<Role>(roleMapper.selectByExample(example));
        return page;
    }

    /**
     * @description: example查询
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: example
     * @return: List<Role>
     */
    @Override
    public List<Role> queryListByExample(Example example) {
        List<Role> roleList = new ArrayList<>();
        if (ObjectUtil.isNotNull(example)) {
            roleList = roleMapper.selectByExample(example);
        }
        return roleList;
    }

    /**
     * @description: 主键查询
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: id
     * @return: Role
     */
    @Override
    public Role queryByPrimaryKey(Long id) {
        Role role = null;
        if (ObjectUtil.isNotNull(id)) {
            role = roleMapper.selectByPrimaryKey(id);
        }
        return role;
    }

    /**
     * @description: 主键删除
     * @author: QiPeng
     * @date: 2021-02-05 13:52:05
     * @param: id
     */
    @Override
    public void deleteByPrimaryKey(Long id) {
        if (ObjectUtil.isNotNull(id)) {
            roleMapper.deleteByPrimaryKey(id);
        }
    }
}