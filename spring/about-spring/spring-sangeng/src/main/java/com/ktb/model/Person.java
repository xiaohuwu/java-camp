package com.ktb.model;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    @Value("${person.nickName}")
    String name;
    @Value("#{20-1}")
    Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
