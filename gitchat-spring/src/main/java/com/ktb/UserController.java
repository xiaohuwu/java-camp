package com.ktb;

import com.ktb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.annotation.Resources;

@Controller
public class UserController {

    public UserService getUserService() {
        return userService;
    }

    @Resource
    @Qualifier("myUserService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    public User getUserById(int id){
        return userService.getUserById(id);
    }


}
