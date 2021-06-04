package com.ktb;

import com.ktb.model.Car;
import com.ktb.model.Person;
import com.ktb.model.StaticCarFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class APP2  {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        String[] allBeanNames = context.getBeanDefinitionNames();
        System.out.println("====<<<<<<<<"+Arrays.asList(context.getBeanDefinitionNames()));

        Car staticCarFactory = (Car) context.getBean("car4");

        System.out.println("staticCarFactory"+staticCarFactory);

        Car car2 = (Car) context.getBean("car2");
        System.out.println(car2);

        Person person = (Person) context.getBean("person");
        System.out.println("person:"+person);

        UserController userController = (UserController) context.getBean("userController");
        System.out.println("userController====>:"+userController.getUserById(1));
    }
}
