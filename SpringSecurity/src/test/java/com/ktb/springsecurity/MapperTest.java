package com.ktb.springsecurity;

import com.ktb.springsecurity.entity.SysUser;
import com.ktb.springsecurity.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void test(){
        List<SysUser> users = sysUserMapper.selectList(null);
        users.forEach((item)->{
            System.out.println("item = " + item);
        });
    }
}
