package com.atguigu.edu;

import com.atguigu.servicebase.config.SwaggerConfig;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.atguigu")
public class EduApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(EduApplication.class, args);
        SwaggerConfig bean = run.getBean(SwaggerConfig.class);
        System.out.println("bed:"+bean);
    }

    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
