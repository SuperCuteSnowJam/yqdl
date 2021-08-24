package com.dxtech.yqdl.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginuser");
        if(loginUser != null){
            return true;
        }
        else {
            //拦截住。未登录。跳转到登录页
            response.sendRedirect("/");
            return false;
        }

    }
}
