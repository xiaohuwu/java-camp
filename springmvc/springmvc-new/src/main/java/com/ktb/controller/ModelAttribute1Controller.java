package com.ktb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttribute1Controller {

    // 使用@ModelAttribute注释的value属性，来指定model属性的名称,model属性值就是方法的返回值
    @ModelAttribute("loginname")
    public String userModel1(
            @RequestParam("loginname") String loginname) {
        return loginname;
    }

    @RequestMapping(value = "/login1")
    public String login1(ModelMap modelMap) {
        Object loginname = modelMap.get("loginname");
        System.out.println("loginname:"+ loginname);
        return "result1";
    }


    @RequestMapping(value = "/login2")
    public String login2(ModelMap modelMap) {
        Object loginname = modelMap.get("loginname");
        System.out.println("loginname22:"+ loginname);
        return "result1";
    }


}
