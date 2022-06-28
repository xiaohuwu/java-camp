package com.atguigu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "userService")
public class UserService {

    // Autowired 有3种注入方式 属性 构造方法 和属性的set 方法
    @Autowired
    UserDao userDao;

//    @Autowired
//    public UserService(UserDao userDao) {
//        this.userDao = userDao;
//    }


//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void add() {
        System.out.println("service add.......");

    }


}
