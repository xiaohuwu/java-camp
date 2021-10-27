package com.ktb.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MySpringExceptionIntegratedHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        // 这里可以根据异常的类型来决定什么样的对策
        System.out.println("异常已经被处理了");
        System.out.println("异常的类型是:" + e.getClass().getName());
        httpServletRequest.setAttribute("ex", e);
        return new ModelAndView("runtimeExceptionPage");
    }
}
