package com.example.newbeemall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafController {
    @GetMapping("/thymeleaf")
    public String hello(HttpServletRequest request, @RequestParam(value = "description", required = false, defaultValue = "springboot-thymeleaf") String description) {
        request.setAttribute("th_background", "black");
        request.setAttribute("title", "html标签演示html标签演示");
        request.setAttribute("th_id", "th_id");
        request.setAttribute("th_name", "th_name");
        request.setAttribute("th_value", "th_value");


        request.setAttribute("th_class", "th_class");
        request.setAttribute("th_href", "www.baidu.com");

        return "thymeleaf";
    }
}
