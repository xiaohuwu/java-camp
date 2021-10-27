package com.ktb.demo;

import com.ktb.demo.qualifier.Hello;
import com.ktb.demo.tx.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:SpringBeans.xml"})
public class HelloTest {
    @Autowired
    @Qualifier("hello1")
    Hello hello;

    @Test
    public void test1() {
        hello.sayHello();
    }

    @Test
    public void  test2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "insert into student values(?,?,?)";
        int update = jdbcTemplate.update(sql, new Object[]{2, "shiyanlou2", 18});
        System.out.println("update:" + update);
    }

    @Test
    public void  test3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "delete  from student where id  = ?";
        int update = jdbcTemplate.update(sql, new Object[]{1});
        System.out.println("delete:" + update);
    }

    @Test
    public void  test4(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        AccountService jdbcTemplate = (AccountService) context.getBean("accountService");
        jdbcTemplate.transfer("Tom","Marry",1000);
    }
}
