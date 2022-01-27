package com.example.springbootkuangsheng.controller;

import com.example.springbootkuangsheng.model.PersonDto;
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
        return hashMap;
    }






}
