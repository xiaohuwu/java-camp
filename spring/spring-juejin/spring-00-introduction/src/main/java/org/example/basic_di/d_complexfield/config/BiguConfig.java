package org.example.basic_di.d_complexfield.config;

import org.example.basic_di.d_complexfield.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "org.example.basic_di.d_complexfield.bean")
public class BiguConfig {

    @Bean
    public Person getPerson() {
        Person person = new Person();
        person.setName("xiaohu");
        return person;
    }

}
