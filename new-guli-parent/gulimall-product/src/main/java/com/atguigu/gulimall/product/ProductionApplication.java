package com.atguigu.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.gulimall.product.dao") // TODO: 2021/9/10  注意这里最好只扫描dao层,如果太宽泛,也能扫描到其他注解，就把同一个类放入容器两次报错
public class ProductionApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductionApplication.class);
    }
}
