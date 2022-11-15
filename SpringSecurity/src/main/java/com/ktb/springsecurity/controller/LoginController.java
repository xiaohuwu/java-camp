package com.ktb.springsecurity.controller;

import com.ktb.springsecurity.entity.User;
import com.ktb.springsecurity.response.ResponseResult;
import com.ktb.springsecurity.service.LoginServcie;
import com.ktb.springsecurity.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginServcie loginServcie;

    @Autowired
    SysUserService sysUserService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        return loginServcie.login(user);
    }

    @GetMapping("/user/info")
    public ResponseResult info(Integer id) {
        User user = sysUserService.getById(id);
        return ResponseResult.ok(user);
    }



}
