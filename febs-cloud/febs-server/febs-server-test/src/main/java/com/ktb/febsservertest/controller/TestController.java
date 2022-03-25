package com.ktb.febsservertest.controller;

import com.ktb.febsservertest.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class TestController {

    @Autowired
    private IHelloService helloService;

    @GetMapping("test1")
    @PreAuthorize("hasAnyAuthority('user:add')")
    public String test1() {
        return "拥有'user:add'权限";
    }

    @GetMapping("test2")
    @PreAuthorize("hasAnyAuthority('user:update')")
    public String test2() {
        return "拥有'user:update'权限";
    }

    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }


    @Autowired
    RestTemplate restTemplate;

    @GetMapping("hello")
    public String hello(String name, HttpServletRequest request) {
//        HttpHeaders headers = new HttpHeaders();
////        Enumeration<String> headerNames = request.getHeaderNames();
////        while (headerNames.hasMoreElements()) {
////            String key = (String) headerNames.nextElement();
////            String value = request.getHeader(key);
////            headers.add(key, value);
////        }
//        return restTemplate.postForObject("http://FEBS-Server-System/hello?name=" + name, new HttpEntity<String>(headers), String.class);

        return helloService.hello(name);
    }


}
