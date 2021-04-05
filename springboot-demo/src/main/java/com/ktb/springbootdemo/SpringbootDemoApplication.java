package com.ktb.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@MapperScan(basePackages = "com.ktb.springbootdemo.mapper")
@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }


//    @Bean
//    public WebLogFilter logFilter() {
//        WebLogFilter filter = new WebLogFilter();
//        return filter;
//    }

}
