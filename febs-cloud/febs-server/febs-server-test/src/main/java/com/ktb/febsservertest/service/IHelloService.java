package com.ktb.febsservertest.service;

import com.ktb.febsservertest.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "FEBS-Server-System",url="http://127.0.0.1:8201", fallbackFactory = HelloServiceFallback.class)
//@FeignClient(value = "FEBS-Server-System", fallbackFactory = HelloServiceFallback.class)
public interface IHelloService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);


}
