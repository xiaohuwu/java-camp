package com.ktb.xuefeng.aop;


import com.ktb.xuefeng.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.time.ZoneId;

@Configuration
@ComponentScan(basePackages = {"com.ktb.xuefeng.service","com.ktb.xuefeng.aop"})
@EnableAspectJAutoProxy
@Slf4j
public class AppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService bean = context.getBean(UserService.class);
        bean.login("bob@example.com", "password");
    }
}
