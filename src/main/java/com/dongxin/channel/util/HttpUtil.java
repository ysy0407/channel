package com.dongxin.channel.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Http工具类
 *
 * @author yusongyuan
 * @create 2018-01-03 13:30
 **/

public class HttpUtil {

    private static HttpSession httpSession = null;

    /**
     * 获取请求客户端的ip地址
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }



    /**
     * 获取session中的指定Attribute

     * @param attributeName
     * @return
     */
    public static Object getSessionAttribute(String attributeName){
        return httpSession.getAttribute(attributeName);
    }

    /**
     * 添加session中的值
     * @param key
     * @param value
     */
    public static void setSessionAttribute(String key, Object value){
        httpSession.setAttribute(key, value);
    }

    /**
     * 移除session中的指定Attribute
     *
     * @param attributeName
     */
    public static void removeSessionAttribute(String attributeName){
        httpSession.removeAttribute(attributeName);
    }

    public static HttpSession getHttpSession() {
        return httpSession;
    }

    public static void setHttpSession(HttpSession httpSession) {
        HttpUtil.httpSession = httpSession;
    }

}
