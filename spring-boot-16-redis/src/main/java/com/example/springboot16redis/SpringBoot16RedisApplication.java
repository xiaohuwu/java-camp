package com.example.springboot16redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

@SpringBootApplication
public class SpringBoot16RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot16RedisApplication.class, args);
    }

//    @Bean
//    public HttpMessageConverters converters() {
//        return new HttpMessageConverters(
//                false, Arrays.asList(new TheCustomConverter()));
//    }


    @Bean
    WebMvcConfigurer configurer () {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addResourceHandlers (ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/pages/**").
                        addResourceLocations("classpath:/my-custom-location/");
            }
        };
    }

    @Bean
    public HttpMessageConverter<?> messageConverter(){
        return new TheCustomConverter();
    }

    @EventListener
    public void handleEvent(Object event) {
        System.out.println("event: "+event);
    }

}
