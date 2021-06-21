package com.ktb.guiguedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ktb.guiguedu.dao")
public class GuiguEduApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuiguEduApplication.class, args);
    }
}
