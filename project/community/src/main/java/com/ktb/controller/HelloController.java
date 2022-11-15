package com.ktb.controller;

import com.ktb.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

@Controller
public class HelloController {

    @Resource
    AlphaService alphaService;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(path = "/hello")
    @ResponseBody
    public String hello() {
        String redisKey = "test:count";
        redisTemplate.opsForValue().set(redisKey, 12);
        return "hello";
    }

    @RequestMapping(path = "/getData")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    @RequestMapping("/http")
    @ResponseBody
    public void http(HttpServletRequest request, HttpServletResponse response) {
        // 获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getParameter(name);
            System.out.println(name + ": " + value);
        }
        System.out.println(request.getParameter("code"));

        // 返回响应数据
        //response.setContentType("text/html;charset=utf-8");
        try (
                PrintWriter writer = response.getWriter();
        ) {
            writer.write("<h1>牛客网</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GET请求
    // /students?current=1&limit=20
    @RequestMapping("/students")
    @ResponseBody
    public void students(@RequestParam(value = "current", required = false) int current,
                         @RequestParam(value = "limit", required = false) int limit
    ) {
        System.out.println("current:" + current);
        System.out.println("limit:" + limit);
    }

    // GET请求
    // /students?current=1&limit=20 路径中带有参数
    @RequestMapping("/room/{id}")
    @ResponseBody
    public void room(@PathVariable int id) {
        System.out.println("id:" + id);
    }

    // POST 请求 返回数据
    // /students
    @RequestMapping(value = "/students",method = RequestMethod.POST)
    @ResponseBody
    public String students(String name, Integer age) {
        System.out.println("name:"+name+"   age:"+ age);
        return "success";
    }

    @RequestMapping(value = "/student_new",method = RequestMethod.GET)
    public String student_new() {
        return "student";
    }

    // 响应HTML数据
    @RequestMapping(value = "/get_school",method = RequestMethod.GET)
    public String get_school(Model model) {
        model.addAttribute("name","at home");
        model.addAttribute("age","18");
        return "view";
    }


    // 响应JSON数据(异步请求)
    // Java对象 -> JSON字符串 -> JS对象
    @RequestMapping(value = "/get_emps",method = RequestMethod.GET)
    @ResponseBody
    public HashMap get_emps() {
        HashMap hashMap = new HashMap();
        hashMap.put("name","xiaphu");
        hashMap.put("age","18");
        return hashMap;
    }

    @RequestMapping(value = "/get_emps_list",method = RequestMethod.GET)
    @ResponseBody
    public List get_emps_list() {
        List list = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("name","xiaphu");
        hashMap.put("age","18");
        list.add(hashMap);
        return list;
    }

}
