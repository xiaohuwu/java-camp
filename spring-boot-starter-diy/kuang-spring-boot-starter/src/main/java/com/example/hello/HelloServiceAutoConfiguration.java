package com.example.hello;

import com.example.hello.properties.HelloServiceProperties;
import com.example.hello.stat.HelloServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)
@ConditionalOnClass(HelloServiceConfiguration.class)
@ConditionalOnProperty(prefix = "com.wisdom", value = "enabled", matchIfMissing = true)
public class HelloServiceAutoConfiguration {


    @Autowired
    private HelloServiceProperties helloServiceProperties;

    @Bean
    @ConditionalOnMissingBean(HelloServiceConfiguration.class)
    public HelloServiceConfiguration helloServiceConfiguration() {
        HelloServiceConfiguration helloService = new HelloServiceConfiguration();
        helloService.setName(helloServiceProperties.getName());
        helloService.setHobby(helloServiceProperties.getHobby());
        return helloService;
    }
}
