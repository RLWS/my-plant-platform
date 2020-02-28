package com.rlws.plant.web.api.interceptor;

import com.alibaba.fastjson.JSON;
import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.SerializeUtils;
import com.rlws.plant.commons.utils.WebUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * @author RLWS_5871
 */
@Component
public class IpInterceptor implements HandlerInterceptor {

    @Value("${ip.white}")
    private String ipWhite;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String clientIp = WebUtils.getIpAddress(httpServletRequest);
        //查看ip是否允许访问
        if (ipWhite.indexOf(clientIp) < 0) {
            //httpServletResponse.getWriter().write(SerializeUtils.serialize(BaseResult.fail("IP不合法")));
            httpServletResponse.getWriter().write(JSON.toJSONString(BaseResult.fail("IP不合法")));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
