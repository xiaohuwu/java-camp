package org.example.basic_di.b_constructor;

import org.example.basic_di.b_constructor.bean.Person;
import org.example.basic_di.b_constructor.config.InjectByConstructorConfiguration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InjectByConstructorXmlApplication {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("basic_di/inject-constructor.xml");
        Person person = beanFactory.getBean(Person.class);
        System.out.println(person);



        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InjectByConstructorConfiguration.class);
        Person base = context.getBean(Person.class);
        System.out.println(base);

    }
}
