package com.example.springbootkuangsheng;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.springbootkuangsheng.model.Dog;
import com.example.springbootkuangsheng.model.Person;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class SpringbootKuangshengApplicationTests {

    @Autowired
    Dog dog;

    @Autowired
    Person person;


    @Test
    void contextLoads() {
        System.out.println("dog = " + dog);
        System.out.println("person = " + person);
        person.getLists().stream().filter((item) -> item.equals("good")).collect(Collectors.toList());
        try {

        } catch (Exception e) {
            e.getCause().printStackTrace();
        }
    }


    /**
     * guava 里面 一些比较实用的工具类
     */
    @Test
    void test_02() {
        List<Integer> listOne = Ints.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> listTwo = Ints.asList(6, 7);
        Set<Integer> difference = Sets.difference(Sets.newHashSet(listOne), Sets.newHashSet(listTwo));
        System.out.println("difference = " + difference);
    }

    @Autowired
    DruidDataSource dataSource;

    @Test
    void test_03() throws SQLException {
        System.out.println("dataSource.getClass() = " + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("dataSource.getMinIdle() = " + dataSource.getMinIdle());
        System.out.println("connection = " + connection);
    }
}
