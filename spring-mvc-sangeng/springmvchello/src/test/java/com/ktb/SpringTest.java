package com.ktb;


import com.ktb.dao.CustomerMapper;
import com.ktb.model.Customer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private CustomerMapper userDao;


    @org.junit.Test
    public void test1(){
        Customer customer1 = userDao.selectByPrimaryKey((long) 1);
        System.out.println(customer1);

    }
}
