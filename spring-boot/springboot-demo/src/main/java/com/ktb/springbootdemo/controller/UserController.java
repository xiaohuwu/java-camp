package com.ktb.springbootdemo.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.ktb.springbootdemo.config.RequestUser;
import com.ktb.springbootdemo.model.User;
import com.ktb.springbootdemo.model.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/xxx-junlin")
    public Object getList() {
        log.info("getList===");
        UserEntity u1 = new UserEntity(null, "shanghai");
        return u1;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/convert")
    public @ResponseBody
    UserEntity converter(@RequestBody UserEntity user) {
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testUser")
    public User testUser(@RequestUser User user) {
        return user;
    }

    @GetMapping("/mytest")
    public HashMap test(@RequestParam Map<String, Object> params){
        HashMap hashMap = new HashMap();
        hashMap.put("ok",true);
        return hashMap;
    }

}
