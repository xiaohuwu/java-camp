package com.ktb.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("userName");
        System.out.println("user = " + user);
        if (user == null) {
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/login_new").forward(request, response);
            return false;
        } else {
            return true;
        }
    }

}
