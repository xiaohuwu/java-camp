package com.ktb.controller;

import com.ktb.model.User;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/xxx-junlin")
    public Object getList() {
        User u1 = new User(null, "shanghai");
        return u1;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/convert")
    public @ResponseBody
    User converter(@RequestBody User user) { //@RequestBody不能去 不然进不了 自定义的解析器
        return user;
    }

}
