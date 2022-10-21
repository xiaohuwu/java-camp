package com.ktb.annotation.a_quickstart.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl2 implements UserDao {

    @Value("${jdbc.password}")
    private String jdbc_password;

    @Override
    public String show() {
        System.out.println("jdbc_password = " + jdbc_password);
        return jdbc_password;
    }
}
