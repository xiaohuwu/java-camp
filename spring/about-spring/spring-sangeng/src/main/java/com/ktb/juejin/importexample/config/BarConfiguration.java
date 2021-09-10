package com.ktb.juejin.importexample.config;

import com.ktb.juejin.importexample.model.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BarConfiguration {

    @Bean
    public Bar bbbar() {
        return new Bar();
    }

}
