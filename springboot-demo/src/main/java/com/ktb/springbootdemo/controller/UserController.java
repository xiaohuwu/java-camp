package com.ktb.springbootdemo.controller;

import com.ktb.springbootdemo.model.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value="/get",method= RequestMethod.GET)
    public Object getList(){
        List<UserEntity> list= new ArrayList<UserEntity>();
        UserEntity u1 = new UserEntity(null, "shanghai");
        list.add(u1);
        return list;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/convert")
    public @ResponseBody
    UserEntity converter(UserEntity user) {
        return user;
    }

}
