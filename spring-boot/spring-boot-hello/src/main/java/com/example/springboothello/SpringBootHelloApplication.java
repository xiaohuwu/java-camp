package com.example.springboothello;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableSwagger2Doc
@MapperScan("com.example.springboothello.mapper")
public class SpringBootHelloApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootHelloApplication.class, args);
//        for (String beanDefinitionName : run.getBeanDefinitionNames()) {
//            System.out.println(beanDefinitionName);
//        }
    }

}
