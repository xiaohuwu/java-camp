package com.ktb.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionAdvice {

    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception e) {
        System.out.println("e = " + e.getStackTrace());
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", e.getMessage());
        mv.setViewName("error");
        return mv;
    }

}
