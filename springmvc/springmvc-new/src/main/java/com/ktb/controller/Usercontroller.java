package com.ktb.controller;

import com.google.gson.Gson;
import com.ktb.model.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 自定义类型解析器 string ---> date
 */
@Controller
public class Usercontroller {



    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String registerForm() {
        return "registerForm";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute LoginUser loginUser) {
        System.out.println("loginUser:" + new Gson().toJson(loginUser));
        return "register";
    }


}
