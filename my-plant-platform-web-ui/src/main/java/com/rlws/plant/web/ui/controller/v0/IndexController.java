package com.rlws.plant.web.ui.controller.v0;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.HttpclientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;


/**
 * 该接口版本是使用fastjson转换JSON数据进行交互
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
    public ModelAndView searchData(HttpServletRequest request, ModelAndView modelAndView, @RequestParam Map<String, String> param, @PathVariable(value = "matrix", required = false) String path) {
        path = path == null ? "" : path;
        System.out.println("请求路径:::" + path);
        String result = HttpclientUtils.post(webApiUrl + path, "JSESSIONID=" + request.getSession().getId(), param);
        JSONObject jsonObject = JSON.parseObject(result);
        int status = jsonObject.getInteger("status");
        if (BaseResult.STATUS_SUCCESS == status) {
            System.out.println(jsonObject.getJSONObject("data"));
            Map resultMap = JSON.parseObject(jsonObject.getString("data"), Map.class);
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
            modelAndView.addObject("message",jsonObject.getString("message"));
        }
        return modelAndView;
    }


    /**
     * ajax异步请求(通用)
     *
     * @param request 请求
     * @param param   请求后台的参数
     * @param path    请求后台的接口路径
     * @return 请求的数据
     */
    @ResponseBody
    @RequestMapping(value = {"ajax/{matrix}"}, method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public String ajaxData(HttpServletRequest request, @RequestParam Map<String, String> param, @PathVariable("matrix") String path) {
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies.toString());
        String result = HttpclientUtils.post(webApiUrl + path, "JSESSIONID=" + request.getSession().getId(), param);
        System.out.println("ajax:::::" + result);
        int status = JSON.parseObject(result).getInteger("status");
        if (BaseResult.STATUS_SUCCESS == status) {
            return JSON.parseObject(result).getString("data");
        } else {
            return "";
        }
    }
}
