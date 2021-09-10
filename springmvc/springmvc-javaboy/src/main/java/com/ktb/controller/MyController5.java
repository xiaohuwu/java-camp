package com.ktb.controller;

import com.google.gson.GsonBuilder;
import com.ktb.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

//请求窄化
@Controller
public class MyController5 {

    @RequestMapping(value = {"/hello4","/hello5"})
    public ModelAndView hello(ModelAndView mv) {
        mv.addObject("name", "MyController5");
        mv.setViewName("hello");
        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("");
        return mv;
    }


    @RequestMapping(value = "/hello6")
    @ResponseBody
    public String hello5() {
        return "Java 语言程序设计";
    }


    @RequestMapping("/book")
    @ResponseBody
    public Book getBookById() {
        Book book = new Book();
        book.setId(1);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        book.setPublish(new Date());
        return book;
    }

}
