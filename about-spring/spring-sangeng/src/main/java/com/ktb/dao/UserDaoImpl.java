package com.ktb.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    public UserDaoImpl() {
        System.out.println("UserDaoImpl run ");
    }

    @Override
    public String show() {
        return "dao impl show ======";
    }

}
