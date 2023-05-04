package com.ktb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class RefreshListener {

    @Bean
    public HttpMessageConverter<?> messageConverter(){
        return new TheCustomConverter();
    }

//    @Autowired
//    private RequestMappingHandlerAdapter handlerAdapter;
//
//    @EventListener
//    public void handleContextRefresh(ContextRefreshedEvent event) {
//        handlerAdapter.getMessageConverters()
//                .stream()
//                .forEach((item)->{
//                    System.out.println(" name:          " + item.toString());
//                });
//    }

}
