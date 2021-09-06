package com.ktb.juejin.importexample.config;

import com.ktb.model.Bartender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class BartenderConfiguration {
    @Bean
    public Bartender zhangxiaosan() {
        return new Bartender("张小三");
    }
    @Bean
    public Bartender zhangdasan() {
        return new Bartender("张大三");
    }
}
