package com.ktb.springbootdemo.controller;

import com.ktb.springbootdemo.service.UndoLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class HomeController {

    @Autowired
    UndoLogService undoLogService;



    @GetMapping("/json")     // <2>
    @ResponseBody
    public String  home_json() {
        HashMap hashMap = new HashMap();
        undoLogService.queryPage(hashMap);
        return "home";

    }
}
