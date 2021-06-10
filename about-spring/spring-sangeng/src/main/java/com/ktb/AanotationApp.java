package com.ktb;

import com.ktb.config.ApplicationConfig;
import com.ktb.dao.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class AanotationApp
{
    public static void main( String[] args )
    {
        //创建容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String item: beanDefinitionNames) {
            System.out.println(item);
        }
        //获取对象
        DruidDataSource userDao = (DruidDataSource) annotationConfigApplicationContext.getBean("getDataSource");
        System.out.println("userDao:"+userDao);

    }
}
