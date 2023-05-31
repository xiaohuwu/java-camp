package com.example.service_hospital;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.example.service_hospital.mapper")
@ComponentScan("com.example")
@SpringBootApplication
public class ServiceHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHospitalApplication.class, args);
    }

}
