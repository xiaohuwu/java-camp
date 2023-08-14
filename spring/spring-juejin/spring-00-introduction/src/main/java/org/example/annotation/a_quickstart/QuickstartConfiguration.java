package org.example.annotation.a_quickstart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuickstartConfiguration {


    @Bean
    public Person getPerson() {
        Person person = new Person();
        person.setAge(18);
        person.setName("gege");
        return person;
    }

}
