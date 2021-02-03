package com.example.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sys.domain.RoleEntity;
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
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    /**
     * @description: 分页查询
     * @author: bianqipeng
     * @date: 2021-02-03 09:54:41
     * @param: page
     * @param: roleEntity
     * @return: IPage<RoleEntity>
     */
    @Override
    public IPage<RoleEntity> queryPageByModel(Page page, RoleEntity roleEntity) {
        IPage<RoleEntity> iPage = null;
        if (ObjectUtil.isNull(page)) {
            return iPage;
        }
        QueryWrapper<RoleEntity> queryWrapper = packageWrapper(roleEntity);
        iPage = baseMapper.selectPage(page, queryWrapper);
        return iPage;
    }

    /**
     * @description: 新增数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:20
     * @param: roleEntity
     */
    @Override
    public void saveModel(RoleEntity roleEntity) {
        if (ObjectUtil.isNull(roleEntity) || ObjectUtil.isNull(roleEntity.getId())) {
            return;
        }
        baseMapper.insert(roleEntity);
    }

    /**
     * @description: 通过主键更新数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:23
     * @param: roleEntity
     * @return: RoleEntity
     */
    @Override
    public void updateModelByPrimaryKey(RoleEntity roleEntity) {
        if (ObjectUtil.isNull(roleEntity) || ObjectUtil.isNull(roleEntity.getId())) {
            return;
        }
        baseMapper.updateById(roleEntity);
    }

    /**
     * @description: 通过QueryWrapper更新数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:26
     * @param: roleEntity
     * @param: queryWrapper
     * @return: RoleEntity
     */
    @Override
    public void updateModelByWrapper(RoleEntity roleEntity, QueryWrapper<RoleEntity> queryWrapper) {
        if (ObjectUtil.isNull(roleEntity) || ObjectUtil.isNull(queryWrapper)) {
            return;
        }
        baseMapper.update(roleEntity, queryWrapper);
    }

    /**
     * @description: 通过主键查询数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:30
     * @param: id
     * @return: RoleEntity
     */
    @Override
    public RoleEntity queryModelByPrimaryKey(Integer id) {
        RoleEntity roleEntity = null;
        if (ObjectUtil.isNotNull(id)) {
            roleEntity = baseMapper.selectById(id);
        }
        return roleEntity;
    }

    /**
     * @description: 通过QueryWrapper查询数据
     * @author: bianqipeng
     * @date: 2021-02-03 09:20:33
     * @param: queryQueryWrapper
     * @return: List<RoleEntity>
     */
    @Override
    public List<RoleEntity> queryModelByWrapper(QueryWrapper<RoleEntity> queryQueryWrapper) {
        List<RoleEntity> roleEntityList = new ArrayList<>(16);
        if (ObjectUtil.isNotNull(queryQueryWrapper)) {
            roleEntityList = baseMapper.selectList(queryQueryWrapper);
        }
        return roleEntityList;
    }

    /**
     * @description: QueryWrapper包装
     * @author: bianqipeng
     * @date: 2021-02-03 09:58:43
     * @param: roleEntity
     * @return: QueryWrapper<RoleEntity>
     */
    private QueryWrapper<RoleEntity> packageWrapper(RoleEntity roleEntity) {
        QueryWrapper<RoleEntity> queryWrapper = new QueryWrapper<>();
        if (ObjectUtil.isNotNull(roleEntity)) {
            queryWrapper
                    .eq(ObjectUtil.isNotEmpty(roleEntity.getId()), RoleEntity.ID, roleEntity.getId())
                    .eq(StrUtil.isNotEmpty(roleEntity.getRoleName()), RoleEntity.ROLE_NAME, roleEntity.getRoleName());
        }
        return queryWrapper;
    }

}