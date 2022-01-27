package com.example.springbootkuangsheng.controller;

import com.example.springbootkuangsheng.model.PersonDto;
import com.wisdom.stat.HelloServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
public class HelloController {


    @Autowired
    HelloServiceConfiguration helloServiceConfiguration;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "postData")
    @ResponseBody
    public HashMap postData(@RequestBody @Valid PersonDto postData) {
        HashMap hashMap = new HashMap();
        hashMap.put("hello","world");
        String name = helloServiceConfiguration.getName();
        String hobby = helloServiceConfiguration.getHobby();
        hashMap.put("name",name);
        hashMap.put("hobby",hobby);
        return hashMap;
    }






}
