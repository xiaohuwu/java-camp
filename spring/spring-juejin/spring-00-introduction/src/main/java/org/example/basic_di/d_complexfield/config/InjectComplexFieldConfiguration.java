package org.example.basic_di.d_complexfield.config;

import org.example.basic_di.d_complexfield.bean.Dog;
import org.example.basic_di.d_complexfield.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.example.basic_di.d_complexfield.bean")
public class InjectComplexFieldConfiguration {


    @Bean
    @Autowired // 高版本可不标注
    public Dog dog(@Qualifier("getPerson") Person administrator) {
        Dog dog = new Dog();
        dog.setName("mimi");
//        dog.setPerson(administrator);
        return dog;
    }




    @Bean
    public Person getPerson() {
        Person person = new Person();
        person.setName("xiaohu");
        return person;
    }
}
