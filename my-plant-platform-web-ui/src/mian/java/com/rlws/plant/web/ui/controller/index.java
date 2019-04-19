package com.rlws.plant.web.ui.controller;

import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.HttpclientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class index {

    @RequestMapping(value = {"","index"},method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        String email = "123@qq.com";
        String s = HttpclientUtils.get("http://127.0.0.1:8081/api/test?email=" + email);
        return s;
    }
}
