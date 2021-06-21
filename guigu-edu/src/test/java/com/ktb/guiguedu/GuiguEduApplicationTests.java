package com.ktb.guiguedu;

import com.ktb.guiguedu.dao.UserMapper;
import com.ktb.guiguedu.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GuiguEduApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------>>>>>>>>>>>>"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

}
