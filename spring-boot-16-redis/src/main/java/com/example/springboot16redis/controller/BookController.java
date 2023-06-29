package com.example.springboot16redis.controller;

import com.example.springboot16redis.User;
import com.example.springboot16redis.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class BookController {


    @Autowired
    private UserRepository userRepository;

    @RequestMapping("hello")
    public String hello() {

        Logger logger = LoggerFactory.getLogger(BookController.class);
        String loggerClassName = logger.getClass().getName();
        log.info("loggerClassName:{}", loggerClassName);
        log.debug("this is debug");

        log.warn("this is warn");
        log.error("this is error");
        log.info("this is info");
        User xiaohu = userRepository.findByName("xiaohu");
        System.out.println("xiaohu = " + xiaohu);
        return "hello";
    }


    @PostMapping(value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public User create(@RequestBody User user) {
//        user.setName("didispace.com : " + user.getName());
//        user.setEmail("didispace.com : " + user.getEmail());
        return user;
    }

}
