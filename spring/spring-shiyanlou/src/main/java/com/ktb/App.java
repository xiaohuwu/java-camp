package com.ktb;

/**
 * Hello world!
 *
 */

import com.ktb.demo.AppConfig;
import com.ktb.demo.bean.Dog;
import com.ktb.demo.bean.HelloWorld;
import com.ktb.demo.bean.FileNameGenerator;
import com.ktb.demo.bean.IAnimal;
import com.ktb.demo.scope.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App{
    private static ApplicationContext context;

    public static void main(String[] args){
         context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        HelloWorld helloBean = (HelloWorld) context.getBean("helloBean");
        FileNameGenerator fileNameGenerator =  context.getBean(FileNameGenerator.class);
        fileNameGenerator.printFileName();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IAnimal bean = annotationConfigApplicationContext.getBean(IAnimal.class);
        bean.getName();
        //作用域的验证
//        CustomerService bean1 = annotationConfigApplicationContext.getBean(CustomerService.class);
//        bean1.setMessage("hell word");
//        CustomerService bean2 = annotationConfigApplicationContext.getBean(CustomerService.class);
//        System.out.println(bean2.getMessage());

//        Dog bean3 = annotationConfigApplicationContext.getBean(Dog.class);
//        System.out.println(bean3.toString());

        Dog bean3 = context.getBean(Dog.class);
        System.out.println(bean3.toString());
    }
}