package com.ktb.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Arrays;

/**
 * Spring 测试 验证 Spring 和Spring MVC 之间的整合
 */
@RunWith(SpringJUnit4ClassRunner.class)//让测试运行与Spring测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringMvc {


    @org.junit.Test
    public void test1(){
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        String[] beanDefinitionNames = app.getBeanDefinitionNames();
//        for (String item: beanDefinitionNames) {
//            System.out.println("item:+++=========>"+item);
//        }



    }


    @Autowired
    ApplicationContext applicationContext;

    @org.junit.Test
    public void printBeans() {
        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }
}
