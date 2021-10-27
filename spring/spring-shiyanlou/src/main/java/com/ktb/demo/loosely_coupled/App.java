package com.ktb.demo.loosely_coupled;

/**
 * Hello world!
 *
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private static ApplicationContext context;

    public static void main(String[] args){
         context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        OutputHelper outputHelper = (OutputHelper) context.getBean("OutputHelper");
        outputHelper.generateOutput();
    }
}