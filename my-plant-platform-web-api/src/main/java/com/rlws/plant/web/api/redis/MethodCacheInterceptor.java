package com.rlws.plant.web.api.redis;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author rlws
 * @date 2020/2/26  17:29
 */
@Component
@Aspect
public class MethodCacheInterceptor {

    @Around("execution (* com.rlws.plant.web.api.controller..*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("AutoAspectJInterceptor begin around");
        Object object = point.proceed();
        System.out.println("AutoAspectJInterceptor end around");
        return object;
    }
}
