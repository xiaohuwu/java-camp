package com.ktb.common.configure;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class FebsOAuth2FeignConfigure {

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }
}
