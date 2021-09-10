package com.ktb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class UserServiceImpl {

    @Autowired
    UserDao userDao;

    @Value("199")
    private int num;

    @Value("三更草堂")
    private String str;

    @Value("#{19+3}")
    private Integer age;

    public void show() {
        System.out.println(userDao.show());
        System.out.println("查询数据库，展示查询到的数据 num:"+num+"str:"+str+"age:"+age);
    }

}
