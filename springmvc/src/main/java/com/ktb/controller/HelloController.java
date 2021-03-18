package com.ktb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/yiidian")
public class HelloController {
    @RequestMapping("/hello.do")
    public void hello(HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello-www.yiidian.com");
    }
}