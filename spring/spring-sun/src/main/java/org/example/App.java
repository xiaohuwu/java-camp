package org.example;

import org.example.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        DruidDataSource bean = ctx.getBean(DruidDataSource.class);
        System.out.println("bean.getUrl() = " + bean.getUrl());
        Person person = ctx.getBean(Person.class);
        System.out.println("person.getBirthDate() = " + person.getBirthDate());
        System.out.println("person.getName() = " + person.getName());
//        System.out.println("bean = " + bean);
//        Person bean1 = ctx.getBean(Person.class);
//        System.out.println("bean1 = " + bean1);
    }
}
