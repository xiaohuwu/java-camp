package com.ktb.xuefeng;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        UserService userService = context.getBean(UserService.class);
//        User user = userService.login("bob@example.com", "password");
//        System.out.println(user.getName());
    }
}
