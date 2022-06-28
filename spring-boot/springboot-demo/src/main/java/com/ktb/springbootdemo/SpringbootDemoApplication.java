package com.ktb.springbootdemo;

import com.ktb.springbootdemo.service.AsyncService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.List;

@SpringBootApplication
@EnableAsync
public class SpringbootDemoApplication {

    @Autowired
    AsyncService asyncService;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDemoApplication.class, args);

    }



    @Bean
    public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }

//    @Bean
//    public WebLogFilter logFilter() {
//        WebLogFilter filter = new WebLogFilter();
//        return filter;
//    }



    @Bean
    public MyMvcConfigurer mvcConfigurer() {
        return new MyMvcConfigurer();
    }

    public static class MyMvcConfigurer implements WebMvcConfigurer {
        public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
            resolvers.add(new GamePHPMethodProcessor());
        }
    }





}
