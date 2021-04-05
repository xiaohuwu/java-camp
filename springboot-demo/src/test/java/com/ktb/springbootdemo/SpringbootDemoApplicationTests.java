package com.ktb.springbootdemo;

import com.ktb.springbootdemo.mapper.UserMapper;
import com.ktb.springbootdemo.model.User;
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

    @Test
    public void testSelect(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
