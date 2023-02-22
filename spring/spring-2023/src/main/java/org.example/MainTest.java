package org.example;

import org.example.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        //  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springContext.xml");
        ApplicationContext run = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("===Spring启动完毕，测试代码开始===");
        Object person01 = run.getBean("person");

        Object person02 = run.getBean("person");

        System.out.println("person01 == person02 : " + (person01 == person02));
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println("person = " + person);
    }


}
