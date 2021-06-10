package com.ktb.test;

import com.ktb.dao.CustomerMapper;
import com.ktb.model.Customer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;

/**
 * Spring 测试 验证 Spring 和Mybatis  之间的整合
 */
@RunWith(SpringJUnit4ClassRunner.class)//让测试运行与Spring测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestSpringAndMybatis {

    @Autowired
    private CustomerMapper userDao;

    @org.junit.Test
    public void test1(){
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("todo-servlet.xml");
//        String[] beanDefinitionNames = app.getBeanDefinitionNames();
//        for (String item: beanDefinitionNames) {
//            System.out.println(item);
//        }


        Customer customer = new Customer();
        customer.setName("xiaohu");
        customer.setGender("男");
        customer.setCreatedAt(new Date());
        customer.setUpdatedAt(new Date());
        userDao.insert(customer);

        Customer customer1 = userDao.selectByPrimaryKey((long) 1);
        System.out.println(customer1);

    }


    @Autowired
    ApplicationContext applicationContext;

    @org.junit.Test
    public void printBeans() {
        System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }
}
