package com.example.common.aspect;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-01-08 14:47:26
 */
@Slf4j
@Aspect
@Component
public class AopLogAspect {

    /**
     * @description: 定义切入点
     * @author: bianqipeng
     * @date: 2021-01-08 14:49:30
     */
    @Pointcut("@annotation(com.example.common.annotation.AopLog)")
    public void logPointCut() {

    }

    /**
     * @description: 定义环绕通知
     * @author: bianqipeng
     * @date: 2021-01-08 14:49:33
     * @param: point
     * @return: Object
     * @throws: Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 开始记录操作数据
        long startTime = System.currentTimeMillis();
        // 类名
        String className = point.getTarget().getClass().getName();
        // 获取执行的方法名称
        String methodName = point.getSignature().getName();
        // 1. 如果是使用的第二种方式，则判断该方法是否使用了改注解
        Object[] args = point.getArgs();
        try {
            String params = JSONUtil.toJsonStr(args[0]);
            //打印请求参数参数
            log.info("{}.{}()【方法请求参数为】：{}", className, methodName, params);
        } catch (Exception e) {
            log.info("{}.{}()【方法请求参数打印失败】：{}", className, methodName, e);
        }
        // 执行目标方法
        Object result = point.proceed();
        // 打印返回结果
        try {
            String s = JSONUtil.toJsonStr(result);
            log.info("{}.{}()【方法返回结果为】：{}", className, methodName, s);
        } catch (Exception e) {
            log.info("{}.{}()【方法返回结果打印失败】：{}", className, methodName, e);
        }
        // 获取执行完的时间
        long time = System.currentTimeMillis() - startTime;
        log.info("{}.{}()【方法执行时长为】：{}{}", className, methodName, time, " ms");
        return result;
    }
}
