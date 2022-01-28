package com.ktb.macrozhengmall.controller;

import com.ktb.macrozhengmall.common.api.CommonResult;
import com.ktb.macrozhengmall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oss")
public class UmsMemberController {

    @Autowired
    UmsMemberService umsMemberService;


    @RequestMapping(value = "/getCode", method = RequestMethod.GET)
    public CommonResult getCode(@RequestParam String phone) {
        CommonResult commonResult = umsMemberService.generateAuthCode(phone);
        return commonResult;
    }


    @RequestMapping(value = "/validateCode", method = RequestMethod.POST)
    public CommonResult validateCode(@RequestParam String phone,@RequestParam String code) {
        CommonResult commonResult = umsMemberService.verifyAuthCode(phone,code);
        return commonResult;
    }


}
