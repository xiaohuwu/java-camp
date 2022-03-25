package com.ktb.febsservertest;

import com.ktb.common.annotation.EnableFebsOauth2FeignClient;
import com.ktb.common.annotation.EnableFebsServerProtect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableFeignClients
@EnableFebsOauth2FeignClient
@EnableFebsServerProtect
public class FebsServerTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FebsServerTestApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        System.out.println("Arrays.toString(beanDefinitionNames) = " + Arrays.toString(beanDefinitionNames));

    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
