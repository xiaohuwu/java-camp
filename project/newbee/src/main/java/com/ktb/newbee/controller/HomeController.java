package com.ktb.newbee.controller;

import com.ktb.newbee.config.Result;
import com.ktb.newbee.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("home")
public class HomeController {

    @Resource
    private HomeService homeService;

    @GetMapping("/index")
    public Result<Object> index() {
        return homeService.index();
    }

}
