package com.example.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.sys.domain.User;
import com.example.sys.mapper.UserMapper;
import com.example.sys.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 用户信息表
 * @author: QiPeng
 * @date: 2021-02-05 16:01:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @description: 新增数据
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: user
     */
    @Override
    public void saveSelective(User user) {
        if (ObjectUtil.isNotNull(user)) {
            userMapper.insertSelective(user);
        }
    }

    /**
     * @description: 通过主键更新数据
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: user
     */
    @Override
    public void updateByPrimaryKeySelective(User user) {
        if (ObjectUtil.isNull(user) || ObjectUtil.isNull(user.getId())) {
            return;
        }
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * @description: 通过example更新数据
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: user
     * @param: example
     */
    @Override
    public void updateByExampleSelective(User user, Example example) {
        if (ObjectUtil.isNull(user) || ObjectUtil.isNull(example)) {
            return;
        }
        userMapper.updateByExampleSelective(user, userMapper);
    }

    /**
     * @description: 通过主键更新数据（可以将指定字段更新为null）
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: user
     * @param: fieldList
     */
    @Override
    public void updateByPrimaryKeySelectiveForce(User user, List<String> fieldList) {
        if (ObjectUtil.isNull(user) || ObjectUtil.isNull(user.getId())) {
            return;
        }
        if (ObjectUtil.isNull(fieldList)) {
            fieldList = new ArrayList<>();
        }
        userMapper.updateByPrimaryKeySelectiveForce(user, fieldList);
    }

    /**
     * @description: 分页查询
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: page
     * @param: example
     * @return: PageInfo<User>
     */
    @Override
    public PageInfo<User> queryPage(PageInfo page, Example example) {
        if (ObjectUtil.isNull(page) || ObjectUtil.isNull(example)) {
            return page;
        }
        //分页查询
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        page = new PageInfo<User>(userMapper.selectByExample(example));
        return page;
    }

    /**
     * @description: example查询
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: example
     * @return: List<User>
     */
    @Override
    public List<User> queryListByExample(Example example) {
        List<User> userList = new ArrayList<>();
        if (ObjectUtil.isNotNull(example)) {
            userList = userMapper.selectByExample(example);
        }
        return userList;
    }

    /**
     * @description: 主键查询
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: id
     * @return: User
     */
    @Override
    public User queryByPrimaryKey(Long id) {
        User user = null;
        if (ObjectUtil.isNotNull(id)) {
            user = userMapper.selectByPrimaryKey(id);
        }
        return user;
    }

    /**
     * @description: 主键删除
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: id
     */
    @Override
    public void deleteByPrimaryKey(Long id) {
        if (ObjectUtil.isNotNull(id)) {
            userMapper.deleteByPrimaryKey(id);
        }
    }

}