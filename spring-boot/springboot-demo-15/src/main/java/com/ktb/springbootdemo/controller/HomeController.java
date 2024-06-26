package com.ktb.springbootdemo.controller;

import com.ktb.springbootdemo.service.UndoLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class HomeController {

    @Autowired
    UndoLogService undoLogService;


    @GetMapping("/json")     // <2>
    @ResponseBody
    public String home_json() {
        HashMap hashMap = new HashMap();
        undoLogService.queryPage(hashMap);
        ArrayList<Object> objects = new ArrayList<>();
        return "home";
    }


    //校验邮箱
    @GetMapping("/checkEmail")
    @ResponseBody
    public String checkEmail() {
        return "home";
    }


}
