package com.example.springbootjwt.service;

import com.example.springbootjwt.model.UserBean;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {

    public UserBean getUser(String username) {
        // 没有此用户直接返回null
        HashMap hashMap = new HashMap();
        UserBean user = new UserBean();
        user.setUsername("xiaohu");
        user.setPassword("123456");
        user.setRole("admin");
        user.setPermission("view");
        return user;
    }

}
