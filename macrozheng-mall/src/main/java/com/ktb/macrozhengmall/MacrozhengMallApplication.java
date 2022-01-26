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

//    @Bean
//    public CommonsRequestLoggingFilter requestLoggingFilter() {
//        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
//        loggingFilter.setIncludeClientInfo(true);
//        loggingFilter.setIncludeQueryString(true);
//        loggingFilter.setIncludePayload(true);
//        loggingFilter.setIncludeHeaders(false);
//        loggingFilter.setMaxPayloadLength(1000);
//        loggingFilter.setAfterMessagePrefix("REQUEST DATA : ");
//        return loggingFilter;
//    }



}