package com.ktb.annotation.a_quickstart.service.impl;

import com.ktb.annotation.a_quickstart.config.InvokeLog;
import com.ktb.annotation.a_quickstart.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
//    @Qualifier("userDaoImpl")
    private UserDao userDao;


    public void delete() {
        System.out.println("UserService.delete");
    }

    @InvokeLog
    public String show() {
        String s = String.valueOf(1 / 0);
        return userDao.show();
    }

}
