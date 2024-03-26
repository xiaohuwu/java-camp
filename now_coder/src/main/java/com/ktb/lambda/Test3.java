package com.ktb.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
    private int id;
    private String name;

    // 构造方法
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

public class Test3 {
    public static void main(String[] args) {
        // 创建Person对象的List
        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "Alice"));
        people.add(new Person(2, "Bob"));
        people.add(new Person(3, "Charlie"));

        // 将List转换为Map，键是Person的id，值是Person对象
        Map<Integer, Person> peopleMap = people.stream()
                .collect(Collectors.toMap(Person::getId, person -> person));

        // 打印Map
        peopleMap.forEach((id, person) -> System.out.println("ID: " + id + ", Name: " + person.getName()));
    }
}
