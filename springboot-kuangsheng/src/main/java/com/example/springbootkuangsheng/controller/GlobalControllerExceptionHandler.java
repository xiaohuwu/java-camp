package com.example.springbootkuangsheng.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@ControllerAdvice
public class GlobalControllerExceptionHandler {


    /**
     * 全局捕捉，自定义返回数据
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleNoTFound() {
        HashMap hashMap = new HashMap();
        hashMap.put("key", "Access denied message here");
        return new ResponseEntity<Object>(hashMap, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


}
