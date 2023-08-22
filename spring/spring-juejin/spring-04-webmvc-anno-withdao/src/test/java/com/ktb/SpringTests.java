package com.ktb;


import com.ktb.config.EnableWebMvcConfiguration;
import com.ktb.config.RootConfiguration;
import com.ktb.entity.Cat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) // 或者SpringRunner
@ContextConfiguration(locations = "classpath:test/spring-test.xml")
public class SpringTests
{

    @Autowired
    Cat cat;

    @Test
    public void testCat() {
        System.out.println(cat);
    }
}
