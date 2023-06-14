package com.example.springboot16redis.proxy;

public class UserServiceImpl {


    public void addUser() {
        System.out.println("添加用户");
    }


    public void updateUser(String str) {
        System.out.println("更新用户信息" + str);
    }

}
