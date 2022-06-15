package com.ktb.java8;

import com.ktb.java8.model.Person;
import com.ktb.java8.model.Student;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StreamSum {


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum = " + sum);


        DoubleSummaryStatistics dstats = DoubleStream.of(5.33d, 2.34d, 5.32d, 2.31d, 3.51d).
                collect(DoubleSummaryStatistics::new, DoubleSummaryStatistics::accept,
                        DoubleSummaryStatistics::combine);
        System.out.println("Max:" + dstats.getMax() + ", Min:" + dstats.getMin());
        System.out.println("Count:" + dstats.getCount() + ", Sum:" + dstats.getSum());
        System.out.println("Average:" + dstats.getAverage());


        //创建一个HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往 HashMap 插入映射
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        int returnedValue = prices.merge("Shirt", 100, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("Price of Shirt: " + returnedValue);

        // 输出更新后的 HashMap
        System.out.println("Updated HashMap: " + prices);

        List<Integer> empIds = Arrays.asList(20, 21);
        List<Student> students = List.of(new Student("小虎", 20),
                new Student("小虎哥", 21)
        );
        List<Student> collect = students.stream().filter((item) -> {
            return empIds.contains(item.getAge());
        }).collect(Collectors.toList());

        HashMap map = new HashMap();
        map.put("a", 1);
        map.remove("a", 1);
        map.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });


        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getName());
        greeter.accept(new Person(10, "小虎"));

        Supplier<Person> personSupplier = () -> {
            return new Person();
        };

        Person person = personSupplier.get();
        System.out.println("person = " + person);

    }


}
