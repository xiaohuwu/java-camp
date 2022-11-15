package com.ktb;

import com.ktb.dao.UserMapper;
import com.ktb.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insertUser(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
    }

    @Test
    public void getUser(){
        User user = userMapper.selectById(1);
        System.out.printf("user=========>:"+user);
    }

    @Test
    public void updateUser(){
       userMapper.updateHeader(1,"6666");
    }
}
