package org.example.service;

import org.example.model.User;

public class UserServiceImpl implements UserService{

    @Override
    public void register(User user) {
        System.out.println("register");
    }

    @Override
    public boolean login(User user) {
        System.out.println("login");
        return true;
    }
}
