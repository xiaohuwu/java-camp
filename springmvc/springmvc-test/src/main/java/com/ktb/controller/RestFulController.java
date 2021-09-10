package com.ktb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.ktb.model.Book;
import com.ktb.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class RestFulController {



    //映射访问路径
    @RequestMapping(value = "/commit/{p1}/{p2}",method = RequestMethod.POST)
    public String index(@PathVariable int p1, @PathVariable String  p2, Model model){

        int result = p1+ Integer.parseInt(p2);
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "结果："+result);
        //返回视图位置
        return "test";
    }


    //映射访问路径
    @RequestMapping(value = "/getName",method = RequestMethod.POST)
    @ResponseBody
    public User index(@RequestBody User user){
        System.out.println(user.getBirthDate());
        //返回视图位置
        return user;
    }


    @RequestMapping("/testDateConverter")
    public Date testDateConverter(Date birthday){
        System.out.println("testDateConverter");
        System.out.println(birthday);
        return birthday;
    }


   // @RequestMapping(value = "/json1",produces = "application/json;charset=utf-8") 解决中文乱码的一种方式
    @RequestMapping(value = "/json1")
    @ResponseBody
    public String json1() throws JsonProcessingException {


//        //创建一个jackson的对象映射器，用来解析数据
//        ObjectMapper mapper = new ObjectMapper();
//        //创建一个对象
//        User user = new User(3, 18,"秦疆1号");
//        user.setBirthDate(new Date());
//        //将我们的对象解析成为json格式
//        String str = mapper.writeValueAsString(user);
//        //由于@ResponseBody注解，这里会将str转成json格式返回；十分方便
        return "";
    }

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    @ResponseBody
    public Book addBook(@RequestBody Book book) {
        System.out.println("book = " + book);
        return book;
    }


}
