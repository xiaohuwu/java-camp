package com.ktb.model;

import org.springframework.stereotype.Component;

@Component(value = "user")
public class User {

    public User() {
        System.out.println("创建了User对象");
    }

    public void add(){
        System.out.println("add......");
    }
}
