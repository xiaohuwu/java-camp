package com.ktb.review.ioc.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("IOCapplication.xml");

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
//        Person bean = context.getBean(Person.class);
//        System.out.println("bean = " + bean);
    }
}
