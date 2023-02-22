package com.example.springboot_07_druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.springboot_07_druid.dao.BookDao;
import com.example.springboot_07_druid.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.Map;

@SpringBootTest
class Springboot07DruidApplicationTests {


    @Autowired
    BookDao bookDao;


    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        System.out.println("------------------");
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        DruidDataSource bean = applicationContext.getBean(DruidDataSource.class);
        System.out.println("bean.getPassword() = " + bean.getPassword());
    }

}
