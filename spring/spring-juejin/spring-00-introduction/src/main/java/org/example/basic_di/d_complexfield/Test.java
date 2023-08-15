package org.example.basic_di.d_complexfield;

import org.example.basic_di.d_complexfield.bean.Dog;
import org.example.basic_di.d_complexfield.bean.Person;
import org.example.basic_di.d_complexfield.config.BiguConfig;
import org.example.basic_di.d_complexfield.config.InjectComplexFieldConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BiguConfig.class);
        Dog bean = ctx.getBean(Dog.class);
        List<Person> person = bean.getPerson();
        System.out.println("person = " + person);


//        ApplicationContext context = new AnnotationConfigApplicationContext(InjectComplexFieldConfiguration.class);
//        Dog dog = context.getBean(Dog.class);
//        Person beanPerson = dog.getPerson();
//        System.out.println("beanPerson = " + beanPerson);

    }

}
