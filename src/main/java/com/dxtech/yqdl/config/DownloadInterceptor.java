package com.dxtech.yqdl.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        request.getSession().setAttribute("currentDownloadUrl",request.getRequestURI());
        response.sendRedirect("/verifilogin");
        return true;
    }
}
