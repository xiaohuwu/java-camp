package com.ktb.febsserversystem.controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("info")
    public String test() {
        return "febs-server-system";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @RequestMapping("hello")
    public String hello(String name) {
        return "hello" + name;
    }
}