package com.ktb.febsserversystem;

import com.ktb.common.annotation.FebsCloudApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@EnableDiscoveryClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@FebsCloudApplication
@EnableTransactionManagement
@MapperScan("com.ktb.febsserversystem.mapper")
public class FebsServerSystemApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(FebsServerSystemApplication.class, args);
        System.out.println("run.getBeanDefinitionNames() = " + Arrays.toString(run.getBeanDefinitionNames()));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
