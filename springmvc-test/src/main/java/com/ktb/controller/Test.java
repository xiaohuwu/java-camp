package com.ktb.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.DateFormat;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String item: beanDefinitionNames) {
            System.out.println(item);
        }
//        //获取对象
//        MappingJackson2HttpMessageConverter messageConverter = (MappingJackson2HttpMessageConverter) app.getBean("httpMessageConverter");
//        DateFormat dateFormat = messageConverter.getObjectMapper().getDateFormat();
//        System.out.println("dateFormat:"+dateFormat);

    }
}
