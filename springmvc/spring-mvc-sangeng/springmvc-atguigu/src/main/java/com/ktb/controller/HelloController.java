package com.ktb.controller;


import com.ktb.model.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping(value = {"/testRequestMapping", "/test"},method = {RequestMethod.POST,RequestMethod.GET},params = {"username=admin"})
    public String testRequestMapping(String username,String password) {
        System.out.println("name:"+ username);
        return "success";
    }

    @RequestMapping(value = {"/"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/testRest/{id}/admin"})
    public String testRest(@PathVariable(name = "id") Integer id) {
        System.out.println("id:"+id);
        return "success";
    }

    @PutMapping(value = {"/putRequestTest"})
    public String putRequestTest() {
        return "success";
    }

    @RequestMapping("/httpServletRequest")
    public String httpServletRequest(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(User user){
        System.out.println("requestBody:"+ user);
        return "success";
    }


    @RequestMapping("/mytestRequestBody")
    public String mytestRequestBody(@RequestBody String  user){
        System.out.println("requestBody:"+ user);
        return "success";
    }


    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope", "hello,request");
        request.getSession().setAttribute("testRequestScope", "hello,session");
        request.getServletContext().setAttribute("testRequestScope", "hello,application");
        return "success";
    }


    @RequestMapping(value = "/testResponseUser",produces = "application/x-result;charset=utf-8")
    @ResponseBody
    public User testResponseUser(User user, RequestEntity<String> requestEntity){
        System.out.println("requestHeader:"+requestEntity.getHeaders());
        System.out.println("requestBody:"+requestEntity.getBody());
        return new User("admin","123456");
    }




}
