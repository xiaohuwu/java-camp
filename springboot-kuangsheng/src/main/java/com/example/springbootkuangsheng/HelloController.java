package com.example.springbootkuangsheng;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class HelloController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @RequestMapping(value = "postData", method = RequestMethod.POST)
    @ResponseBody
    public HashMap postData() {
        HashMap hashMap = new HashMap();

        hashMap.put("hello","world");
        return hashMap;
    }

}
