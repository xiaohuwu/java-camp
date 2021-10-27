package com.ktb.demo.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Dog implements IAnimal {
    @Value("dog")
    private String name;

    @Autowired
    private Person person;

    public Dog() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        System.out.println(person);
    }

    public Dog(Person person) {
        this.person = person;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getName() {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", person=" + this.person +
                '}';
    }
}
