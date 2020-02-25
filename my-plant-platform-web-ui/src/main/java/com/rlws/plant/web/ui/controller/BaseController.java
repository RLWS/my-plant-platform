package com.rlws.plant.web.ui.controller;

import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.Map;

/**
 * 基本的控制器,所有控制器的父类,包含了控制器的一些公共方法
 *
 * @author rlws
 * @date 2020/2/25  10:56
 */
public abstract class BaseController {
    /**
     * 将后台api返回的结果解析放入modelAndView中
     *
     * @param modelAndView modelAndView
     * @param map          后台api返回的结果
     * @return 存放了视图与数据的modelAndView
     */
    public ModelAndView mapAnalysis(ModelAndView modelAndView, Map map) {
        Iterator iteratorResult = map.keySet().iterator();
        while (iteratorResult.hasNext()) {
            String key = iteratorResult.next().toString();
            if ("pageView".equals(key)) {
                //视图页面
                modelAndView.setViewName(map.get(key).toString());
            } else {
                modelAndView.addObject(key, map.get(key));
            }
        }
        return modelAndView;
    }
}
