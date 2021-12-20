package com.lou.springboot.controller;

import com.lou.springboot.dao.UserDao;
import com.lou.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyBatisController {
    @Autowired
    UserDao userDao;

    @GetMapping("/users")
    public List<User> queryUsers() {
        return userDao.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getOne(@PathVariable Integer id) {
        return userDao.getOne(id);
    }

    @PostMapping("/users")
    public Boolean postUsers(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return userDao.insertUser(user) > 0;
    }

    @PostMapping("/users/{id}")
    public Boolean updateUsers(@PathVariable Integer id, String name, String password) {
        User user = userDao.getOne(id);
        user.setName(name);
        user.setPassword(password);
        return userDao.updateUser(user) > 0;
    }

    @DeleteMapping("/users/{id}")
    public Boolean deleteUser(@PathVariable Integer id) {
        return userDao.deleteOne(id) > 0;
    }

}
