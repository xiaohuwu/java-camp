package com.ktb.macrozhengmall;


import com.ktb.macrozhengmall.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MacrozhengMallApplication.class})
public class MacrozhengMallApplicationTests {

    @Autowired
    ApplicationContext applicationContext;


    @Autowired
    RedisService redisService;

    @Test
    public void contextLoads() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }

    @Test
    public void test_01() {
        String s = redisService.get("code_" + "18589717969");
        System.out.println("s = " + s);
    }

}
