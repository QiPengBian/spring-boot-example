package com.example.sys.repository;

import com.example.sys.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-02-07 14:02:57
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * @description: 通过username查询用户
     * @author: bianqipeng
     * @date: 2021-02-07 14:34:51
     * @param: username
     * @return: User
     */
    User queryUserByUsername(String username);

    /**
     * @description: TODO
     * @author: bianqipeng
     * @date: 2021-02-07 14:42:22
     * @param: username
     * @return: List<User>
     */
    List<User> queryUsersByUsername(String username);
}
