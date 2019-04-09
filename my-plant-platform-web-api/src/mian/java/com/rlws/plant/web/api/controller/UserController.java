package com.rlws.plant.web.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.MapperUtils;
import com.rlws.plant.domain.User;
import com.rlws.plant.web.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //注册用户提交信息判断用户邮箱是否已经注册ajax
    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String selectByPrimaryKey(String email) {
        System.out.println(email);
        User user1 = userService.selectByPrimaryKey(email);
        if (user1 != null){
            return MapperUtils.getBeanToJson(BaseResult.success(user1));
        }
        return MapperUtils.getBeanToJson(BaseResult.fail());
    }

    //默认进入的页面
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String main() {
        return "test";
    }

}