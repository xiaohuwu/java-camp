package com.ktb.controller;

import com.google.gson.Gson;
import com.ktb.model.ModelAttributeUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ModelAttribute4Controller {

    // 这时这个方法的返回值并不是表示一个视图名称，而是model属性的值，视图名称是@RequestMapping的value值。
    // Model属性名称由@ModelAttribute(value=””)指定，相当于在request中封装了username（key）=admin（value）。
    @RequestMapping(value="/login4")
    @ModelAttribute(value="username")
    public String login3(Model model) {
        return "admin";
    }

    /*
     *  @ModelAttribute注释方法参数，会自动入参
     *  loginname控件的值会自动入参到User的loginname属性
     *  password控件的值会自动入参到User的password属性
     */
    @RequestMapping(value="/login5")
    public String login5(@ModelAttribute(value="user") ModelAttributeUser user,Model model) {
        user.setUsername("管理员");
        return "result5";
    }

}
