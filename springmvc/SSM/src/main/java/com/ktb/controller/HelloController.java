package com.ktb.controller;

import com.ktb.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        // 返回一个字符串 "success" 作为视图名称
        return "hello";
    }

    @RequestMapping(value = "/register")
    public String Register(User user, Model model) {  // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
        // 在 model 中添加一个名为 "user" 的 user 对象
        model.addAttribute("user", user);
        // 返回一个字符串 "success" 作为视图名称
        return "success";
    }

}
