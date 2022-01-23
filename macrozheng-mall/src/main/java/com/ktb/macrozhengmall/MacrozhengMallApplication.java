package com.ktb.macrozhengmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.ktb.macrozhengmall.dao")
public class MacrozhengMallApplication {

    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(MacrozhengMallApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionNames = " + beanDefinitionName);
        }
    }

}
