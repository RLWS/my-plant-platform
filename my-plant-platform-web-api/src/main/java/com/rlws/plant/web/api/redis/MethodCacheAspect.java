package com.rlws.plant.web.api.redis;

import com.alibaba.fastjson.JSON;
import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.web.api.annotation.RedisCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author rlws
 * @date 2020/2/26  17:29
 */
@Component
@Aspect
public class MethodCacheAspect {

    /**
     * Redis操作类
     */
    @Autowired
    private RedisHandle redisHandle;

    @Pointcut("execution (* com.rlws.plant.web.api.controller..*.*(..))")
    private void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Method method = ((MethodSignature) point.getSignature()).getMethod();
        //缓存标识
        boolean isCache = false;
        //缓存的key
        StringBuilder redisKey = new StringBuilder(method.getName());
        //获取传入的形参
        Object[] args = point.getArgs();
        for (Object o : args) {
            //形参中的HttpServletRequest和HttpServletResponse不要拼入redisKey
            if (!(o instanceof HttpServletRequest) && !(o instanceof HttpServletResponse)) {
                redisKey.append("_").append(o.toString());
            }
        }
        if (method.isAnnotationPresent(RedisCache.class)) {
            //存在缓存注解,获取缓存的数据直接返回
            String result = redisHandle.stringGet(redisKey.toString());
            if (result != null && !"".equals(result)) {
                redisHandle.updateTime(redisKey.toString(), 30);
                System.out.println("从缓存取:" + redisKey);
                return result;
            }
            //Redis缓存中并不存在,需要加入
            isCache = true;
        }
        //执行方法
        Object returnValue = point.proceed();
        if (isCache) {
            //加入缓存
            redisHandle.stringSet(redisKey.toString(), JSON.toJSONString(returnValue), 30);
        }
        System.out.println("从MySQL取:" + redisKey);
        return returnValue;
    }
}
