package com.example.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sys.domain.Role;
import com.example.sys.mapper.RoleMapper;
import com.example.sys.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色信息表
 *
 * @author QiPeng
 * @email 276109002@qq.com
 * @date 2021-01-12 13:24:51
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    /**
     * @description: 分页查询
     * @author: bianqipeng
     * @date: 2021-02-03 09:54:41
     * @param: page
     * @param: role
     * @return: IPage<role>
     */
    @Override
    public IPage<Role> queryPageByModel(Page page, Role role) {
        IPage<Role> iPage = null;
        if (ObjectUtil.isNull(page)) {
            return iPage;
        }
        QueryWrapper<Role> queryWrapper = packageWrapper(role);
        iPage = baseMapper.selectPage(page, queryWrapper);
        return iPage;
    }

    /**
     * @description: 新增数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:20
     * @param: role
     */
    @Override
    public void saveModel(Role role) {
        if (ObjectUtil.isNull(role) || ObjectUtil.isNull(role.getId())) {
            return;
        }
        baseMapper.insert(role);
    }

    /**
     * @description: 通过主键更新数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:23
     * @param: role
     * @return: role
     */
    @Override
    public void updateModelByPrimaryKey(Role role) {
        if (ObjectUtil.isNull(role) || ObjectUtil.isNull(role.getId())) {
            return;
        }
        baseMapper.updateById(role);
    }

    /**
     * @description: 通过QueryWrapper更新数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:26
     * @param: role
     * @param: queryWrapper
     * @return: role
     */
    @Override
    public void updateModelByWrapper(Role role, QueryWrapper<Role> queryWrapper) {
        if (ObjectUtil.isNull(role) || ObjectUtil.isNull(queryWrapper)) {
            return;
        }
        baseMapper.update(role, queryWrapper);
    }

    /**
     * @description: 通过主键查询数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:30
     * @param: id
     * @return: role
     */
    @Override
    public Role queryModelByPrimaryKey(Integer id) {
        Role role = null;
        if (ObjectUtil.isNotNull(id)) {
            role = baseMapper.selectById(id);
        }
        return role;
    }

    /**
     * @description: 通过QueryWrapper查询数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:33
     * @param: queryQueryWrapper
     * @return: List<role>
     */
    @Override
    public List<Role> queryModelByWrapper(QueryWrapper<Role> queryQueryWrapper) {
        List<Role> roleList = new ArrayList<>(16);
        if (ObjectUtil.isNotNull(queryQueryWrapper)) {
            roleList = baseMapper.selectList(queryQueryWrapper);
        }
        return roleList;
    }

    /**
     * @description: QueryWrapper包装
     * @author: bianqipeng
     * @date: 2021-02-03 09:58:43
     * @param: role
     * @return: QueryWrapper<role>
     */
    private QueryWrapper<Role> packageWrapper(Role role) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotNull(role)) {
            queryWrapper
                    .eq(ObjectUtil.isNotEmpty(role.getId()), Role.ID, role.getId())
                    .eq(StrUtil.isNotEmpty(role.getRoleName()), Role.ROLE_NAME, role.getRoleName());
        }
        return queryWrapper;
    }

}