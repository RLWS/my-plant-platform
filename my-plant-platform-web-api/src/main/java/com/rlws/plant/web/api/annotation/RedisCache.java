package com.rlws.plant.web.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能:添加在Method上,自动将结果放入Redis缓存中,Key由"方法名+形参"构成
 * 注意1:目前Method的形参只能有"八大基本数据类型"和"HttpServletRequest","HttpServletResponse"
 * 注意2:目前Method的返回值只能说Object或String类型(待优化)
 *
 * @author rlws
 * @date 2020/2/28  13:27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisCache {

}
