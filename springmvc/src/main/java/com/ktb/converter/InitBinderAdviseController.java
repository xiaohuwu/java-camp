package com.ktb.converter;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

/**
 * 和 message converter 类似 全局的数据类型 转换器
 * @InitBinder 也可以定义在controller内部
 */

@ControllerAdvice
public class InitBinderAdviseController {

    @InitBinder
    public void dateTypeBinder(WebDataBinder webDataBinder){
        //往数据绑定器中添加一个DateFormatter日期转化器。
        webDataBinder.registerCustomEditor(Date.class, new DateEditor());
    }

}
