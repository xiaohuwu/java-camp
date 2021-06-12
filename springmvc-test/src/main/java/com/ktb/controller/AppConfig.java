package com.ktb.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.HashMap;
import java.util.Map;

//@EnableWebMvc
@Configuration
public class AppConfig {

    @Bean
    HttpRequestHandler httpRequestHandler () {
        return new MyHttpRequestHandler();
    }

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping () {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Map<String, Object> map = new HashMap<>();
        map.put("/app/**", httpRequestHandler());
        mapping.setUrlMap(map);
        return mapping;
    }
}