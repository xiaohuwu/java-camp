package com.ktb.springbootdemo;

import com.ktb.springbootdemo.service.AsyncService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
@EnableAsync
public class SpringbootDemoApplication {

    @Autowired
    AsyncService asyncService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);

    }


//    @Bean
//    public WebLogFilter logFilter() {
//        WebLogFilter filter = new WebLogFilter();
//        return filter;
//    }

}
