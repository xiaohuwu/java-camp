package com.ktb.demo;

import com.ktb.demo.bean.Dog;
import com.ktb.demo.bean.IAnimal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "com.ktb.demo")
@ImportResource("SpringBeans.xml")
public class AppConfig {

}
