package com.example.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
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
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
