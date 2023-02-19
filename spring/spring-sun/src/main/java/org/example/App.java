package org.example;

import org.example.model.Person;
import org.example.model.User;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        DruidDataSource bean = ctx.getBean(DruidDataSource.class);
//        System.out.println("bean.getUrl() = " + bean.getUrl());
//        Person person = ctx.getBean(Person.class);
//        System.out.println("person.getBirthDate() = " + person.getBirthDate());
//        System.out.println("person.getName() = " + person.getName());
        UserService bean1 = (UserService) ctx.getBean(UserService.class);
        bean1.login(new User());
    }
}
