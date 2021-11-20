package com.ktb.annotation.a_quickstart.config;

import com.ktb.annotation.a_quickstart.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuickstartConfiguration {

    @Bean("person")
    public Person getPerson() {
        return new Person();
    }

}
