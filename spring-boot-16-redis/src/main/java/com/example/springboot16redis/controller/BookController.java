package com.example.springboot16redis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookController {

    @RequestMapping("hello")
    public String hello(){
        log.info("this is info");
        log.warn("this is warn");
        return "hello";
    }

}
