package com.ktb.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class SGControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handleException(Exception e){
        return new ResponseResult(500,e.getMessage());
    }
}