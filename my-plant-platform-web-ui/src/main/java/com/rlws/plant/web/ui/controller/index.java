package com.rlws.plant.web.ui.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.HttpclientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
public class index {

    @RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        String s = HttpclientUtils.get("http://127.0.0.1:8081/api/v1/index");
        System.out.println("s::::::::::::::"+s);
        String data = JSON.parseObject(s).getString("data");
        System.out.println(data);
        Map map = JSON.parseObject(data, Map.class);
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            String key = iterator.next().toString();
            modelAndView.addObject(key,map.get(key));
        }
        System.out.println(map);
        System.out.println("questionDetails:::"+map.get("questionDetails"));
        System.out.println("questionsUrgent:::"+map.get("questionsUrgent"));
        System.out.println("questions:::"+map.get("questions"));
        System.out.println("categories:::"+map.get("categories"));
        return modelAndView;
    }

    @RequestMapping(value = {"rlws"}, method = RequestMethod.GET)
    @ResponseBody
    public String postTest() {
        String email = "123@qq.com";
        String url = "http://127.0.0.1:8081/api/v1/rlws";
        HashMap map = new HashMap<String, String>();
        map.put("email", email);
        map.put("email", email);
        String s = HttpclientUtils.post(url, map);
        return s;
    }
}
