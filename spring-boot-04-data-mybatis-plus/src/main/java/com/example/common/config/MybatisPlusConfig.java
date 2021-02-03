package com.example.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @description: 分页配置
 * @author: QiPeng
 * @date: 2020-12-30 15:27:00
 */
@Configurable
@MapperScan(basePackages = "com.example.**.mapper")
public class MybatisPlusConfig {

    /**
     * @description: 分页插件
     * @author: QiPeng
     * @date: 2020-12-30 15:40:38
     * @return: MybatisPlusInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }
}
