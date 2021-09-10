package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.atguigu.gulimall.product")

public class ProductionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductionApplication.class);
    }
}
