package com.ktb.annotation.a_quickstart;

import com.ktb.annotation.a_quickstart.bean.Person;
import com.ktb.annotation.a_quickstart.config.QuickstartConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(QuickstartConfiguration.class);
        Person bean = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println(bean.toString());
    }
    
}
