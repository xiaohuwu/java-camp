package com.ktb;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.UserService;
import com.ktb.model.Book;
import com.ktb.model.Dept;
import com.ktb.model.Order;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;


public class BeanTest {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        Book book = (Book) app.getBean("book");
        System.out.println("book = " + book);

//        Order order = (Order) app.getBean("order");
//        System.out.println("order = " + order);
//        Order order1 = (Order) app.getBean("order");
//        System.out.println("order1 = " + order1);

        Dept dept = (Dept) app.getBean("dept");
        System.out.println("dept = " + dept);

        DruidDataSource bean = app.getBean(DruidDataSource.class);
        String username = bean.getPassword();
        System.out.println("username = " + username);
        System.out.println("bean = " + bean);

        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        UserService userService = (UserService) app.getBean("userService");
        userService.getUserDao().print();

        app.close();




    }
}
