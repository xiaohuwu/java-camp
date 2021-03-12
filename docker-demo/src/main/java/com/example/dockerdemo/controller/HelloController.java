package com.example.dockerdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @RequestMapping("/")
    public Map<String, Object> getUser() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangxing");
        map.put("age", 27);
        return map;
    }

    @RequestMapping("/getUsers")
    public Map<String, Object> getUsers() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangxing");
        map.put("age", 27);
        return map;
    }
}
