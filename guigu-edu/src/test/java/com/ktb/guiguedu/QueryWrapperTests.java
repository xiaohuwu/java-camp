package com.ktb.guiguedu;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ktb.guiguedu.dao.UserMapper;
import com.ktb.guiguedu.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueryWrapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .isNull("name")
                .ge("age", 12)
                .isNotNull("email");
        int result = userMapper.delete(queryWrapper);
        queryWrapper.between("age", 20, 30);
        System.out.println("delete return count = " + result);
    }

}
