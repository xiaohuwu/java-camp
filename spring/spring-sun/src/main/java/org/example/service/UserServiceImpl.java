package org.example.service;

import org.example.model.User;
import org.example.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {
        System.out.println("register");
    }

    @Override
    public boolean login(String userName, String age) {
        System.out.println("login");
        return true;
    }
}
