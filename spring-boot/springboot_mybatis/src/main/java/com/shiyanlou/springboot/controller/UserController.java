package com.shiyanlou.springboot.controller;

import com.shiyanlou.springboot.entity.User;
import com.shiyanlou.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    public IUserService userService;

    @Value("${hello}")
    public String value;


    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String save(User user) {
        userService.save(user);
        return "save success";
    }

    @RequestMapping(
            value = "{id}",
            produces = "application/json",
            method=RequestMethod.PUT)
    public String update(User user, @PathVariable int id) {
        if (userService.findById(id) == null) {
            return "not exist";
        }
        if (user.getId() != id) {
            return "Unmatched parameters";
        }
        userService.update(user);
        return "update success";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id) {
        if (userService.findById(id) == null) {
            return "not exist";
        }
        userService.delete(id);
        return "update success";
    }


    @GetMapping
    public List<User> index() {
        return userService.list();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        return userService.findById(id);
    }


    @GetMapping("/getValue")
    public String getValue(){
        return  value;
    }

}