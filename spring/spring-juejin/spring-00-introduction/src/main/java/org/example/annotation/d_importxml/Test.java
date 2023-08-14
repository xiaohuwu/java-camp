package org.example.annotation.d_importxml;

import org.example.annotation.a_quickstart.Person;
import org.example.annotation.c_scan.Cat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext annotationConfigApplicationContext = new ClassPathXmlApplicationContext("annotation/import-anno.xml");
        Arrays.stream(annotationConfigApplicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        Person bean = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println("bean = " + bean);


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportXmlAnnotationConfiguration.class);
        Cat bean1 = applicationContext.getBean(Cat.class);
        System.out.println("bean1 = " + bean1);
    }
}
