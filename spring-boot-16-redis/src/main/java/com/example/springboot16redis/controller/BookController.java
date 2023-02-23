package com.example.springboot16redis.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class BookController {

    @RequestMapping("hello")
    public String hello(){
        log.debug("this is debug");

        log.warn("this is warn");
        log.error("this is error");
        log.info("this is info");


        return "hello";
    }

}
