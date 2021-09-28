package com.ktb.springbootdemo;

import com.ktb.springbootdemo.mapper.UserMapper;
import com.ktb.springbootdemo.model.User;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Test
    void contextLoads() {

    }

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private DataSource dataSource;

//    @Test
//    public void testSelect() {
//        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
//    }

    @Test
    public void testDatabase() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("connection:" + connection);
        //dataSource.getUsername();
    }


}
