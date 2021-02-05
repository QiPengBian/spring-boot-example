package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-02-05 15:25:17
 * 注意：tk.mybatis包扫描需要使用：tk.mybatis.spring.annotation.MapperScan;
 */
@MapperScan(basePackages = "com.example.**.mapper")
@SpringBootApplication
public class SpringBoot04DataTkMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04DataTkMybatisApplication.class, args);
    }

}
