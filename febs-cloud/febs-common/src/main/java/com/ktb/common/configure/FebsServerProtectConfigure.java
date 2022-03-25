package com.ktb.common.configure;

import com.ktb.common.interceptor.FebsServerProtectInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class FebsServerProtectConfigure implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor febsServerProtectInterceptor() {
        return new FebsServerProtectInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(febsServerProtectInterceptor());
    }
}
