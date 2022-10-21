package com.ktb.annotation.a_quickstart.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserDaoImpl implements UserDao {

    @Value("${jdbc.password}")
    private String jdbc_password;

    @Override
    public String show() {
        System.out.println("jdbc_password = " + jdbc_password);
        return jdbc_password;
    }
}
