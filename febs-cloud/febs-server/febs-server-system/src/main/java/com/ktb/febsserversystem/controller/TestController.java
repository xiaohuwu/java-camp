package com.ktb.febsserversystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
public class TestController {

    @GetMapping("info")
    public String test() {
        return "febs-server-system";
    }

    @GetMapping("current_user")
    public Principal currentUser(Principal principal) {
        return principal;
    }

    @RequestMapping("hello")
    public String hello(String name) {
        log.info("/hello服务被调用");
        return "hello" + name;
    }
}