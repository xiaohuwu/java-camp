package com.ktb.controller;

import com.google.gson.Gson;
import com.ktb.converter.DateEditor;
import com.ktb.model.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * 通过   @InitBinder string -----> date
 */
    @Controller
    public class InitbinderUsercontroller {

        @RequestMapping(value = "/bindRegisterForm", method = RequestMethod.GET)
        public String registerForm() {
            return "bindRegisterForm";
        }


//        //     在控制器初始化时注册属性编辑器
//        @InitBinder
//        public void initBinder(WebDataBinder binder){
//            // 注册自定义编辑器
//            System.out.println("initBinder===========>");
//            binder.registerCustomEditor(Date.class, new DateEditor());
//        }


    @RequestMapping(value = "/bindRegister", method = RequestMethod.POST)
    public String register(@ModelAttribute LoginUser loginUser) {
        System.out.println("loginUser:" + new Gson().toJson(loginUser));
        return "register";
    }


}
