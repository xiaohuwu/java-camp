package com.ktb.juejin.property;

import com.ktb.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/person.properties")
@Configuration
public class MainConfig {

    @Bean
    public Person person(){
        return new Person();
    }

}
