package com.rlws.plant.web.admin.controller;

import com.alibaba.fastjson.JSON;
import com.rlws.plant.domain.User;
import com.rlws.plant.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

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

}
