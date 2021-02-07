package com.example.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 自定义日志注解
 * @author: bianqipeng
 * @date: 2021-01-08 14:45:36
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AopLog {

    /**
     * 标题
     */
    String title() default "";
}
