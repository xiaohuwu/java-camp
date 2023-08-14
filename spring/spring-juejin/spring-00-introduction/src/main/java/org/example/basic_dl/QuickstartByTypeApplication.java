package org.example.basic_dl;

import org.example.basic_dl.b_bytype.DemoDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuickstartByTypeApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("basic_dl/quickstart-bytype.xml");
        DemoDao bean = classPathXmlApplicationContext.getBean(DemoDao.class);
        System.out.println("bean = " + bean);
    }
}
