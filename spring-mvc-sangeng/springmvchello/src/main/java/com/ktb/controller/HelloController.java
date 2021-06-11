package com.ktb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public ModelAndView helloWorld(@PathVariable(value = "path",required = false) String path) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","HelloSpringMVC!");
        mv.setViewName("hello"); //: /WEB-INF/jsp/hello.jsp
        return mv;
    }



    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(@PathVariable(value = "path",required = false) String path) {
        return "test";
    }


}
