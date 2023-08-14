package org.example.basic_di.b_constructor.config;

import org.example.basic_di.b_constructor.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjectByConstructorConfiguration {

    @Bean
    public Person getPerson() {
        Person person = new Person("gege", 18);
        return person;
    }
}
