package com.ktb.common.configure;

import com.ktb.common.entity.FebsConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Base64Utils;

public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String zuulToken = new String(Base64Utils.encode(FebsConstant.ZUUL_TOKEN_VALUE.getBytes()));
        requestTemplate.header(FebsConstant.ZUUL_TOKEN_HEADER, zuulToken);

        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (details instanceof OAuth2AuthenticationDetails) {
            String authorizationToken = ((OAuth2AuthenticationDetails) details).getTokenValue();
            requestTemplate.header("Authorization", "bearer " + authorizationToken);
        }
    }
}
