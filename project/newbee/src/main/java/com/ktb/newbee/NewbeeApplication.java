package com.ktb.newbee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ktb.newbee.dao")
public class NewbeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewbeeApplication.class, args);
    }

}
