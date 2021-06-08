package com.ktb.converter;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

@ControllerAdvice
public class InitBinderAdviseController {

//    @InitBinder
//    public void dateTypeBinder(WebDataBinder webDataBinder){
//        //往数据绑定器中添加一个DateFormatter日期转化器。
//        webDataBinder.registerCustomEditor(Date.class, new DateEditor());
//    }

}
