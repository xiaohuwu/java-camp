package com.ktb.springsecurity.controller;

import com.ktb.springsecurity.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/testBody")
    public User testBody(@RequestBody User user){
        return user;
    }

}
