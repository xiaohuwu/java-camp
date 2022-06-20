package com.ktb.java8;

import com.ktb.java8.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MapDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        String collect = list.stream().map((item) -> item.toUpperCase()).collect(Collectors.joining(","));
        System.out.println("collect = " + collect);

        Person person = new Person(1, "小虎");
        boolean flag = false;
        if (person != null && person.getName() != null) {
            String name = person.getName();
            System.out.println("name = " + name);
        }
        boolean fl = false;
        ArrayList arrayList = new ArrayList();

        String s = Optional.ofNullable(person).map(Person::getName).orElse(null);
        System.out.println("s = " + s);
    }



}
