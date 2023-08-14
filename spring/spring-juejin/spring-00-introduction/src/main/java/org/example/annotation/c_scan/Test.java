package org.example.annotation.c_scan;

import org.example.annotation.a_quickstart.Person;
import org.example.annotation.a_quickstart.QuickstartConfiguration;
import org.example.annotation.c_scan.config.ComponentScanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);
        Cat bean = annotationConfigApplicationContext.getBean(Cat.class);
        System.out.println("bean = " + bean);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);

    }
}
