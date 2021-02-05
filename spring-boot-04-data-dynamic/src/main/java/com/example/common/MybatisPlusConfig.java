package com.example.common;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 分页配置
 * @author: QiPeng
 * @date: 2020-12-30 15:27:00
 */
@Configuration
@MapperScan(basePackages = "com.example.**.mapper")
public class MybatisPlusConfig {

    /**
     * @description: 分页插件
     * @author: QiPeng
     * @date: 2020-12-30 15:40:38
     * @return: MybatisPlusInterceptor
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        return new MybatisPlusInterceptor();
    }
}
