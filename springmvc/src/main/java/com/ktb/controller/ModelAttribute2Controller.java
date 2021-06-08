package com.ktb.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModelAttribute2Controller {

    //没有返回值的情况
    @ModelAttribute
    public void myModel(@RequestParam(required = false) String name,
                        @RequestParam(required = false) String password,
                        Model model) {
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        System.out.println("res:" + new Gson().toJson(model));
    }

    @RequestMapping(value = "/login15")
    public String model(Model model) {
        System.out.println("res12e:" + new Gson().toJson(model));
        return "result2";
    }
}
