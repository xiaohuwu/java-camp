package com.ktb.controller;

import com.google.gson.Gson;
import com.ktb.model.MybatisUser;
import com.ktb.model.User;
import com.ktb.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class HelloController {

    private User user;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    //response header  Content-Type: application/xml
    @ResponseBody
    public String handleJson() {
        System.out.println("Got json request");
        return "{ \"userName\": \"Joe\"}";
    }

    @RequestMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String handleXML() {
        System.out.println("Got xml request");
        return "success";
    }


    @RequestMapping(value = "/hello_id", params = "id=10")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello-www.yiidian.com");
    }


    // spring mvc 传过来的值 需与前端一致，不然需要用注解
//    @RequestMapping("/param.do")
//    public String save(@RequestParam("username") String  userName, Integer age){
//        System.out.println("用户名："+userName);
//        System.out.println("年龄："+age);
//        return "success";
//    }


    @RequestMapping(value = "/param.do", method = RequestMethod.POST)
    public String saveData(User user) {
        System.out.println("用户名：" + user.getName());
        System.out.println("年龄：" + user.getAge());
        return "success";
    }


    @RequestMapping(value = "/preConvert", method = RequestMethod.GET)
    public String preConvert(User user) {
        return "preConvert";
    }

    @RequestMapping(value = "/Convert", method = RequestMethod.POST)
    public String Convert(User user, Model model) {
        System.out.println( new Gson().toJson(user));
        model.addAttribute("user",user);
        return "convert";
    }


    @RequestMapping(value = "/ConvertJson", method = RequestMethod.POST)
    @ResponseBody
    public User ConvertJson(@RequestBody User user) {
        System.out.println( "res:  "+new Gson().toJson(user));
        return user;
    }


    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(@RequestBody MybatisUser user) {
        userService.saveUser(user);
        return "success";
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public List getAllUser() {
       List userList =  userService.getAllUser();
        return userList;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody  User user) {
        userService.addUser(user);
        return "ok";
    }

}