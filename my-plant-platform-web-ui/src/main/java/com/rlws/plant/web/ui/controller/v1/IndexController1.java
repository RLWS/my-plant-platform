package com.rlws.plant.web.ui.controller.v1;

import com.alibaba.fastjson.JSON;
import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.HttpclientUtils;
import com.rlws.plant.commons.utils.SerializeUtils;
import com.rlws.plant.web.ui.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


/**
 * 该接口版本是使用java原生态序列化BaseResult进行交互
 *
 * @author rlws
 */
@Slf4j
@Controller
@RequestMapping(value = "v1")
public class IndexController1 extends BaseController {

    @Value("${web.api.url}"+"v1/")
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
    public ModelAndView searchData(HttpServletRequest request, ModelAndView modelAndView, @RequestParam Map<String, String> param, @PathVariable(value = "matrix", required = false) String path) throws IOException, ClassNotFoundException {
        path = path == null ? "" : path;
        System.out.println("请求路径:::" + path);
        String result = HttpclientUtils.post(webApiUrl + path, "JSESSIONID=" + request.getSession().getId(), param);
        BaseResult baseResult = (BaseResult) SerializeUtils.unSerialize(result);
        if (BaseResult.STATUS_SUCCESS == baseResult.getStatus()) {
            Map resultMap = (Map) baseResult.getData();
            modelAndView = this.mapAnalysis(modelAndView,resultMap);
        } else {
            modelAndView.setViewName("error");
            modelAndView.addObject("message",baseResult.getMessage());
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
    public String ajaxData(HttpServletRequest request, @RequestParam Map<String, String> param, @PathVariable("matrix") String path) throws IOException, ClassNotFoundException {
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies.toString());
        String result = HttpclientUtils.post(webApiUrl + path, "JSESSIONID=" + request.getSession().getId(), param);
        BaseResult baseResult = (BaseResult) SerializeUtils.unSerialize(result);
        if (BaseResult.STATUS_SUCCESS == baseResult.getStatus()) {
            return JSON.toJSONString(baseResult.getData());
        } else {
            return "";
        }
    }
}
