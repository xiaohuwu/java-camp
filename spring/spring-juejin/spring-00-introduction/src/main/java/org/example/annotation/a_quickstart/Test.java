package org.example.annotation.a_quickstart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(QuickstartConfiguration.class);
        Person bean = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println("bean = " + bean);
    }
}
