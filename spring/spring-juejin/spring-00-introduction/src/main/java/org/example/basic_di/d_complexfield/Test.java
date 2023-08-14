package org.example.basic_di.d_complexfield;

import org.example.basic_di.c_value_spel.config.InjectValueConfiguration;
import org.example.basic_di.d_complexfield.bean.Dog;
import org.example.basic_di.d_complexfield.bean.Person;
import org.example.basic_di.d_complexfield.config.BiguConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BiguConfig.class);
        Dog bean = ctx.getBean(Dog.class);
        Person person = bean.getPerson();
        System.out.println("person = " + person);
    }
}
