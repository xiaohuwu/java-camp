package com.ktb.springbootdemo;

import com.alibaba.druid.pool.DruidDataSource;
import com.ktb.springbootdemo.mapper.UserMapper;
import com.ktb.springbootdemo.model.User;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Test
    void contextLoads() {

    }

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HikariDataSource dataSource;

    @Test
    public void testSelect(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testDatabase(){
        dataSource.getUsername();
    }
    

}
