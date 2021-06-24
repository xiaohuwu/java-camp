package com.atguigu.edu.controller;

import com.atguigu.servicebase.config.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/eduservice/user")
@CrossOrigin
public class EduController {


    @PostMapping(value = "login")
    public R Login() {
        return R.ok().data("token", "admin");
    }

    @GetMapping(value = "info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://img2.baidu.com/it/u=4033504488,813972093&fm=26&fmt=auto&gp=0.jpg");
    }

}
