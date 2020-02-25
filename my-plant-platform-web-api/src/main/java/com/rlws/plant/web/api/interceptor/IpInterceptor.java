package com.rlws.plant.web.api.interceptor;

import com.rlws.plant.commons.dto.BaseResult;
import com.rlws.plant.commons.utils.SerializeUtils;
import com.rlws.plant.commons.utils.WebUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RLWS_5871
 */
public class IpInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String clientIp = WebUtils.getIpAddress(httpServletRequest);
        //httpServletResponse.getWriter().write(SerializeUtils.serialize(BaseResult.fail()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
