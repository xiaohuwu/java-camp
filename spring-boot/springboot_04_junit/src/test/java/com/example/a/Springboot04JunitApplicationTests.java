package com.example.a;

import com.example.junit.Springboot04JunitApplication;
import com.example.junit.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Springboot04JunitApplication.class)
class Springboot04JunitApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    void contextLoads() {
        userDao.save();
    }

}
