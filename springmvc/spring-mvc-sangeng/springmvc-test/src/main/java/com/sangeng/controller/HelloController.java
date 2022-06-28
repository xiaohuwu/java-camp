package com.sangeng.controller;

import com.sangeng.controller.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/register")
    public String hello() {
        return "/register.jsp";
    }

    @RequestMapping("/createUser")
    public String createUser(ModelAndView modelAndView, User user) {

        modelAndView.addObject("user",user);
        return "/success.jsp";
    }

}
