package com.ktb.review.ioc.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class IocConfigTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(IocConfig.class);
        Person bean = annotationConfigApplicationContext.getBean(Person.class);
        Person bean1 = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println("bean = " + bean1.equals(bean));


//        String[] namesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
//        for (String name : namesForType) {
//            System.out.println(name);
//        }


        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);


    }
}
