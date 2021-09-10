package com.ktb.juejin.event;

import com.ktb.juejin.lifecycle.Car;
import com.ktb.model.Boss;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ktb")
public class ExtConfig {

    @Bean(initMethod= "init",destroyMethod = "destroy")
    public Car getBoss(){
        return  new Car();
    }

}
