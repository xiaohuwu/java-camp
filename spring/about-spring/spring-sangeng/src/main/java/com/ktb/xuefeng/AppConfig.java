package com.ktb.xuefeng;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AppConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService bean1 = context.getBean(UserService.class);


        MailService bean = context.getBean(MailService.class);
        UserService userService = bean.getUserService();
        System.out.println("bean = " + bean);
    }
}
