package com.ktb.controller;
import com.ktb.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
public class ReviewController {


    @RequestMapping(value = "/testPath", params = "testParam=123", headers = "testHeader=123", method = RequestMethod.GET)
    public String test() {
        return "success";
    }

    @RequestMapping(value = "/testPath1", consumes = "application/json")
    public String test1() {
        return "success";
    }

    @RequestMapping(value = "/queryId/{id}", consumes = "application/json")
    public String test2(@PathVariable("id") String id) {
        System.out.println("id = " + id);
        return "success";
    }


    /**
     * 如果需要使用**@RequestBody**来获取请求体中Json并且进行转换，要求请求头 Content-Type 的值要为： application/json
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", consumes = "application/json")
    public String test3(@RequestBody List<User> user) {
        System.out.println("id = " + user);
        return user.toString();
    }


    /**
     *http://localhost:8080/userQuery?name=geg&age=24
     * @param user
     * @return
     */
    @RequestMapping(value = "/userQuery123", consumes = "application/json")
    public String test4(User user) {
        System.out.println("id = " + user);
        return user.toString();
    }

}
