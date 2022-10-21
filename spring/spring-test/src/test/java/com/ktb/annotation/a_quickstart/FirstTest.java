package com.ktb.annotation.a_quickstart;


import com.ktb.annotation.a_quickstart.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//让测试运行与Spring测试环境
@ContextConfiguration(locations = "classpath:beans.xml")//设置Spring配置文件或者配置类
public class FirstTest {

    @Autowired
    AccountService accountService;


    @Test
    public void test() {
        accountService.transfer(1, 2, 50D);
    }
}
