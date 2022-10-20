package com.ktb.annotation.a_quickstart.service.impl;

import com.ktb.annotation.a_quickstart.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
//    @Qualifier("userDaoImpl")
    private UserDao userDao;

    public void show() {
        userDao.show();
    }

}
