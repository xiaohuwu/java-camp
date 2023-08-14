package org.example.basic_dl.a_byname;

import org.example.basic_dl.a_byname.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuickstartByNameApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("basic_dl/quickstart-byname.xml");
        Person bean = (Person) classPathXmlApplicationContext.getBean("person");
        System.out.println("bean = " + bean);
    }
}
