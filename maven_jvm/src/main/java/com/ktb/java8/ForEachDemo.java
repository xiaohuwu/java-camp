package com.ktb.java8;

import com.ktb.java8.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ForEachDemo {
    public static void main(String[] args) {
        System.out.println("ForEachDemo");
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Mahesh"));
        list.add(new Person(2, "Ram"));
        list.add(new Person(3, "Krishna"));
        Consumer<Person> style = person -> System.out.println(person.toString());
        list.forEach(style);
        int pId = 2;
        Predicate<Person> predicate = (Person t) -> t.getPid() == pId;
        list.removeIf(predicate);

        UnaryOperator<Person> unaryOpt = person -> {
            person.setName(person.getName().concat(" -God"));
            return person;
        };
        list.replaceAll(unaryOpt);


    }

    private static Person modifyName(Person p) {
        p.setName(p.getName().concat(" -God"));
        return p;
    }

}
