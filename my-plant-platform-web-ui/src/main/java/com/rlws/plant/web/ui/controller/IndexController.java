package com.rlws.plant.web.ui.controller;

import com.alibaba.fastjson.JSON;
import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.HttpclientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author rlws
 */
@Slf4j
@Controller
public class IndexController {

    @Value("${web.api.url}")
    private String webApiUrl;

    /**
     * 页面跳转带参数(通用)
     *
     * @param modelAndView 返回的数据和视图名称
     * @param param        请求后台的参数
     * @param path         请求后台的接口路径
     * @return 视图和数据
     */
    @RequestMapping(value = {"", "/{matrix}"})
    public ModelAndView searchData(ModelAndView modelAndView, @RequestParam Map<String, String> param, @PathVariable(value = "matrix", required = false) String path) {
        path = path == null ? "" : path;
        System.out.println("请求路径:::" + path);
        String result = HttpclientUtils.post(webApiUrl + path, param);
        int status = JSON.parseObject(result).getInteger("status");
        if (BaseResult.STATUS_SUCCESS == status) {
            System.out.println(JSON.parseObject(result).getJSONObject("data"));
            Map resultMap = JSON.parseObject(JSON.parseObject(result).getString("data"), Map.class);
            Iterator iteratorResult = resultMap.keySet().iterator();
            while (iteratorResult.hasNext()) {
                String key = iteratorResult.next().toString();
                //视图页面
                if ("pageView".equals(key)) {
                    modelAndView.setViewName(resultMap.get(key).toString());
                } else {
                    modelAndView.addObject(key, resultMap.get(key));
                }
            }
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }


    /**
     * ajax异步请求(通用)
     *
     * @param param 请求后台的参数
     * @param path  请求后台的接口路径
     * @return 请求的数据
     */
    @ResponseBody
    @RequestMapping(value = {"ajax/{matrix}"}, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String ajaxData(@RequestParam Map<String, String> param, @PathVariable("matrix") String path) {
        String result = HttpclientUtils.post(webApiUrl + path, param);
        System.out.println("ajax:::::" + result);
        int status = JSON.parseObject(result).getInteger("status");
        if (BaseResult.STATUS_SUCCESS == status) {
            return JSON.parseObject(result).getString("data");
        } else {
            return "";
        }
    }
}
