package com.ktb.common.febsregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FebsRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FebsRegisterApplication.class, args);
    }

}
