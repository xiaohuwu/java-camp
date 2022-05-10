package com.ktb;

import com.ktb.config.ApplicationConfig;
import com.ktb.model.DruidDataSource;
import com.ktb.xuefeng.Validators;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */

public class AanotationApp {
    public static void main(String[] args) {
        //创建容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String item : beanDefinitionNames) {
            System.out.println(item);
        }
        Validators bean = annotationConfigApplicationContext.getBean(Validators.class);
        System.out.println("bean.getValidators().size() = " + bean.getValidators().size());


    }
}
