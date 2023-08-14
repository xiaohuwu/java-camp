package org.example.annotation.d_importxml;

import org.example.annotation.a_quickstart.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfigConfiguration {

    @Bean
    Person getPerson(){
        return new Person();
    }
}
