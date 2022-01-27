package com.example.springbootkuangsheng;

import com.example.springbootkuangsheng.model.Dog;
import com.example.springbootkuangsheng.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.stream.Collectors;

@SpringBootTest
class SpringbootKuangshengApplicationTests {

    @Autowired
    Dog dog;

    @Autowired
    Person person;



    @Test
    void contextLoads() {
        System.out.println("dog = " + dog);
        System.out.println("person = " + person);
        person.getLists().stream().filter((item) -> item.equals("good")).collect(Collectors.toList());
        try {

        }catch (Exception e) {
            e.getCause().printStackTrace();
        }
    }


    @Test
    void test_02() {

    }
}
