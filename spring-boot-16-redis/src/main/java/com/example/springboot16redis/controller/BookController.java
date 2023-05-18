package com.example.springboot16redis.controller;

import com.example.springboot16redis.User;
import com.example.springboot16redis.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class BookController {


    @Autowired
    private UserRepository userRepository;

    @RequestMapping("hello")
    public String hello() {
        log.debug("this is debug");

        log.warn("this is warn");
        log.error("this is error");
        log.info("this is info");
        User xiaohu = userRepository.findByName("xiaohu");
        System.out.println("xiaohu = " + xiaohu);
        return "hello";
    }

}
