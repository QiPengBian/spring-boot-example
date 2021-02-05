package com.example.sys.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-02-02 17:14:35
 */
@Data
@Component
@ConfigurationProperties(prefix = "example")
public class DbProperties {

    /**
     * 数据库类型：mysql、oracle、sqlserver、postgresql
     */
    private String databaseType;

    /**
     * mybatis类型：mybatis-plus、tk-mybatis
     */
    private String mybatisType;

}
