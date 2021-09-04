package com.ktb.controller;

import com.ktb.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;


@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public ModelAndView helloWorld(@PathVariable(value = "path",required = false) String path) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","HelloSpringMVC!");
        mv.setViewName("hello"); //: /WEB-INF/jsp/hello.jsp
        return mv;
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(@PathVariable(value = "path",required = false) String path) {
        return "test";
    }


    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    @ResponseBody
    public Customer custom(@RequestBody Customer customer) { // 非json格式不能用@RequestBody
        return customer;
    }

//    @RequestMapping(value = "/convertString",produces = "text/plain")
    @RequestMapping(value = "/convertString")
    @ResponseBody
    public String convertString(String  customer) {
        return customer;
    }

    //http://localhost:8080/testRquestParam?id=1&name=xiaohu&likes=ge&likes=xiaoyue
    //http://localhost:8080/testRquestParam?id=1&name=xiaohu&likes=ge,xiaoyue 这两种传参形式都可以
    @RequestMapping("/testRquestParam")
    public String testRquestParam(Integer id, @RequestParam("name") String name, String[] likes){
        System.out.println("testRquestParam");
        System.out.println(id);
        System.out.println(name);
        System.out.println(Arrays.toString(likes));
        return "/success.jsp";
    }

    @RequestMapping("/testRquestParam1")
    public String testRquestParam1(){

        return "/success.jsp";
    }

    @RequestMapping(value="/baseType")
    @ResponseBody
    public String baseType(Integer id){
        return "id:"+id;
    }

    @RequestMapping(value="/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "id",required = true, defaultValue = "11") Integer id){
        return "id:"+id;
    }





}
