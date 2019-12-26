package com.rlws.plant.web.admin.controller;

import com.alibaba.fastjson.JSON;
import com.rlws.plant.domain.User;
import com.rlws.plant.web.admin.service.UserService;
import com.rlws.plant.web.admin.utils.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisManager redisManager;

    //注册用户提交信息判断用户邮箱是否已经注册ajax
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String selectByPrimaryKey(String email) {
        System.out.println(email);
        User user1 = userService.selectByPrimaryKey(email);
        System.out.println(user1);
        return "test";
    }

    //默认进入的页面
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String main() {
        return "test";
    }

    //redis测试
    @RequestMapping(value = "redis",method = RequestMethod.GET)
    @ResponseBody
    public String redis() {
        Jedis jedis = redisManager.getResource();
        String result = jedis.get("name");
        if (jedis != null)
        jedis.close();
        return result;
    }

}
