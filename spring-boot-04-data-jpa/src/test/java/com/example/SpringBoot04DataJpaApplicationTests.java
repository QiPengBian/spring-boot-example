package com.example;

import com.example.sys.domain.User;
import com.example.sys.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot04DataJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    void queryUserByUsername() {
        User user = userRepository.queryUserByUsername("zhangsan");
        System.out.println(user);
    }

    @Test
    void queryUsersByUsername() {
        List<User> userList = userRepository.queryUsersByUsername("zhangsan");
        userList.forEach(System.out::println);
    }

}
