package com.example.springboot_05_mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.example.springboot_05_mybatis.mapper.UserMapper;
import com.example.springboot_05_mybatis.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void add() {
        User user = new User();
        user.setAge(20);
        user.setName("xiaohuge");
        user.setUserName("小虎哥");
        user.setAddressStr("cd");
        user.setPassword("123456");
        int insert = userMapper.insert(user);
    }

    @Test
    public void delete() {
//        int i = userMapper.deleteById(6);
        userMapper.deleteBatchIds(Arrays.asList(5));
    }


    @Test
    public void testUpdate() {
        LambdaUpdateWrapper<User> userWrapper = new UpdateWrapper<User>().lambda();
        userWrapper.eq(User::getId, 5).set(User::getUserName,"小虎哥哥");
        userMapper.update(null, userWrapper);
    }

}
