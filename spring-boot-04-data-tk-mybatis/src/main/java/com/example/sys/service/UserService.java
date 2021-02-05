package com.example.sys.service;

import com.example.sys.domain.User;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @description: 用户信息表
 * @author: QiPeng
 * @date: 2021-02-05 16:01:56
 */
public interface UserService {

    /**
     * @description: 新增数据
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: user
     */
    void saveSelective(User user);

    /**
     * @description: 通过主键更新数据
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: user
     */
    void updateByPrimaryKeySelective(User user);

    /**
     * @description: 通过example更新数据
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: user
     * @param: example
     */
    void updateByExampleSelective(User user, Example example);

    /**
     * @description: 修改数据(可以将指定字段修改成null)
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: user
     * @param: fieldList
     */
    void updateByPrimaryKeySelectiveForce(User user, List<String> fieldList);

    /**
     * @description: 分页查询
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: page
     * @param: example
     * @return: PageInfo<User>
     */
    PageInfo<User> queryPage(PageInfo page, Example example);

    /**
     * @description: example查询
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: example
     * @return: List<User>
     */
    List<User> queryListByExample(Example example);

    /**
     * @description: 主键查询
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: id
     * @return: User
     */
    User queryByPrimaryKey(Long id);

    /**
     * @description: 主键删除
     * @author: QiPeng
     * @date: 2021-02-05 16:01:56
     * @param: id
     */
    void deleteByPrimaryKey(Long id);
}

