package com.atguigu.gulimall.product;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
@MapperScan("com.atguigu.gulimall.product.dao") // TODO: 2021/9/10  注意这里最好只扫描dao层,如果太宽泛,也能扫描到其他注解，就把同一个类放入容器两次报错
public class ProductionApplication implements CommandLineRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ProductionApplication.class);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        log.info("beanDefinitionNames====:"+beanDefinitionNames.length);
        for (String item : beanDefinitionNames){
             log.info("item====:"+item);
        }
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        String[] names = applicationContext.getBeanDefinitionNames();
//        int index = 1 ;
//        for (String name : names) {
//            log.info("{}: {}", index++ , name );
//        }
//        log.info("项目启动 容器注入javaBean:{}个.",names.length);
    }
}
