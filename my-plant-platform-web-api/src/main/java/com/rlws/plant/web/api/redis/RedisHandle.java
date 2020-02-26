package com.rlws.plant.web.api.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author RLWS_5871
 */
@Component
public class RedisHandle {

    @Autowired
    private JedisPool jedisPool;

    private Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 保存一个永久的String类型
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public String stringSet(String key, String value) {
        String set = getJedis().set(key, value);
        return set;
    }

    /**
     * 保存一个限时的String类型
     *
     * @param key    键
     * @param value  值
     * @param expire 时间(单位:秒)
     * @return
     */
    public Long stringSet(String key, String value, int expire) {
        getJedis().set(key, value);
        return updateTime(key, expire);
    }

    /**
     * 根据key获取value
     *
     * @param key 传入的key
     * @return 返回获取到值
     */
    public String stringGet(String key) {
        return getJedis().get(key);
    }

    /**
     * 更新key的过期时间
     *
     * @param key    要更新的key值
     * @param expire 要更新的时间
     * @return
     */
    public Long updateTime(String key, int expire) {
        return getJedis().expire(key, expire);
    }

    /**
     * 判断改key是否存在缓存
     * @param key 需要判断的key
     * @return 是否存在缓存
     */
    public boolean exists(String key) {
        return stringGet(key).trim().length() == 0;
    }
}
