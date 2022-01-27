package com.example.springbootkuangsheng.controller;

import com.example.hello.HelloService;
import com.example.springbootkuangsheng.model.PersonDto;

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
    HelloService helloService;

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
        String name = helloService.getName();
        Integer hobby = helloService.getAge();
        hashMap.put("name",name);
        hashMap.put("age",hobby);
        return hashMap;
    }






}
