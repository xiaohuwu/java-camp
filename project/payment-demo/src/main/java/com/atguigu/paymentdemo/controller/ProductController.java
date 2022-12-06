package com.atguigu.paymentdemo.controller;

import com.atguigu.paymentdemo.vo.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/product")
@CrossOrigin //跨域
public class ProductController {

    @GetMapping("/test")
    public R test() {
        return R.ok().data("now", new Date()) ;
    }

}
