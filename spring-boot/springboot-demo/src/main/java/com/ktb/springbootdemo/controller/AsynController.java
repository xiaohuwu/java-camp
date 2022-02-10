package com.ktb.springbootdemo.controller;

import com.ktb.springbootdemo.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AsynController {


    @Autowired
    AsyncService asyncService;



    @RequestMapping("/test")
    public void test() {
        log.info(Thread.currentThread().getName() + " Asyncontroller");
        asyncService.asyncSay();
    }
}
