package com.ktb.febsservertest.configure;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

@Configuration
public class FebsOAuth2FeignConfigure {
//    @Bean(value = "RequestInterceptor1")
//    public RequestInterceptor oauth2FeignRequestInterceptor12() {
//        return requestTemplate -> {
//            Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
//            if (details instanceof OAuth2AuthenticationDetails) {
//                String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
//                requestTemplate.header(HttpHeaders.AUTHORIZATION, "bearer " + authorizationToken);
//            }
//        };
//    }

    @Bean
    Logger.Level feignLoggerLeave() {
        return Logger.Level.FULL;
    }

}
