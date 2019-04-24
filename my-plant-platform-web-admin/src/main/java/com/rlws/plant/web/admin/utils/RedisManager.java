package com.rlws.plant.web.admin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisManager {

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis = null;

    public Jedis getResource() {
        if (jedis == null)
            jedis = jedisPool.getResource();
        return jedis;
    }
}
