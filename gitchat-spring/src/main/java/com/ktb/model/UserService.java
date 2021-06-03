package com.ktb.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "userService")
public class UserService {

    //1 定义 user 类型
    @Autowired
    private User user;
    //2 生成set 方法
    public void setUser(User user) {
        this.user = user;
    }

    public void add(){
        System.out.println("service....");
        user.add();
    }

}
