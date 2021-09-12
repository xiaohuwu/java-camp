package com.atguigu.gulimall.product.controller;


import com.atguigu.common.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @GetMapping("/mytest")
    @ResponseBody
    public HashMap test(@RequestParam Map<String, Object> params){
        HashMap hashMap = new HashMap();
        hashMap.put("ok",true);
        return hashMap;
    }
}
