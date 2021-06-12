package com.ktb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class HelloController {
    private Logger logger = Logger.getLogger(getClass().getSimpleName());

//    @RequestMapping("/hello")
//    public  String  hello(){
//        logger.info("hello===========");
//        return "hello";
//    }

   @RequestMapping("/hello_word")
    public  String  hello_word(){
        logger.info("hello===========");
        return "hello";
    }
}
