package com.ktb.auth.properties;

import com.ktb.auth.configure.FebsClientsProperties;
import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:febs-auth.properties"})
@ConfigurationProperties(prefix = "febs.auth")
public class FebsAuthProperties {

    private FebsClientsProperties[] clients = {};
    private int accessTokenValiditySeconds = 60 * 60 * 24;
    private int refreshTokenValiditySeconds = 60 * 60 * 24 * 7;


    private String anonUrl;

    //验证码配置类
    private FebsValidateCodeProperties code = new FebsValidateCodeProperties();
}
