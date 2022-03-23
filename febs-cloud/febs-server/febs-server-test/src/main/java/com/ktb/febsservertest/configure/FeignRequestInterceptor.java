package com.ktb.febsservertest.configure;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (details instanceof OAuth2AuthenticationDetails) {
            String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
            requestTemplate.header("Authorization", "bearer " + authorizationToken);
        }
    }
}
