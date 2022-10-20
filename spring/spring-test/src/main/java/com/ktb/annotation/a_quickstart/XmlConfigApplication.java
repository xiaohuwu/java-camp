package com.ktb.annotation.a_quickstart;

import com.ktb.annotation.a_quickstart.bean.Person;
import com.ktb.annotation.a_quickstart.config.QuickstartConfiguration;
import com.ktb.annotation.a_quickstart.service.impl.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class XmlConfigApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserService bean = classPathXmlApplicationContext.getBean(UserService.class);
        bean.show();
    }


}
