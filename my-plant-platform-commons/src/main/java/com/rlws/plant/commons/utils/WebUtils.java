package com.rlws.plant.commons.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rlws
 * @date 2020/1/20  13:27
 */
public class WebUtils {

    /**
     * 取不到值时
     */
    private final static String UN_KNOWN = "unknown";

    /**
     * 逗号
     */
    private static final String COMMA = ",";

    /**
     * 获取IP地址
     * @param request   请求
     * @return IP地址
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.contains(COMMA)) {
            return ip.split(COMMA)[0];
        } else {
            return ip;
        }
    }
}
