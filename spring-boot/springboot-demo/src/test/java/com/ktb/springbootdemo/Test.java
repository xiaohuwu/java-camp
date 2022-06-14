package com.ktb.springbootdemo;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
     * *    形参列表和返回值类型相同！（针对于情况1和情况2）
     */
    @org.junit.jupiter.api.Test
    public void test1() {
        Consumer<String> test = new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        test.accept("6666");
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("*******************");

        PrintStream ps = System.out;
        Consumer<String> con2 = System.out::println;
        con2.accept("beijing");

    }


    //Supplier中的T get()
    //Employee中的String getName()
    @org.junit.jupiter.api.Test
    public void test2() {
        Employee emp = new Employee(1001, "Tom", 23, 5600);

        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        System.out.println("*******************");
        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }


    @org.junit.jupiter.api.Test
    public void test3() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        Consumer consumer = System.out::println;
        strings.forEach(consumer);
    }

    // 情况三：类 :: 实例方法 (有难度)
    // Comparator中的int comapre(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @org.junit.jupiter.api.Test
    public void test5() {
        Comparator<String> com1 = (s1, s2) -> {
            int result = 1 + 1;
            return s1.compareTo(s2);
        };
        System.out.println(com1.compare("abc", "abd"));

        System.out.println("*******************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abd", "abm"));
    }


    // Function中的R apply(T t)
    // Employee中的String getName();
    @org.junit.jupiter.api.Test
    public void test7() throws InterruptedException {
        Employee employee = new Employee(1001, "Jerry", 23, 6000);

        Function<Employee, String> func1 = e -> e.getName();
        System.out.println(func1.apply(employee));

        System.out.println("*******************");

        Function<Employee, String> func2 = Employee::getName;
        System.out.println(func2.apply(employee));


        BlockingQueue blockingQueue = new LinkedBlockingQueue<>();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 5, TimeUnit.MINUTES,blockingQueue);
        threadPoolExecutor.execute(Test::print);
    }

    private static void print(){
        System.out.println(Thread.currentThread().getName() + "-->" + System.currentTimeMillis() + "ms");
    }

    @org.junit.jupiter.api.Test
    public void test8() throws InterruptedException {
        List<String> strList = Arrays.asList(new String[] { "a", "c", "4" });
        strList.stream().sorted(String::compareToIgnoreCase).forEach(System.out::println);
        System.out.println("=============>");
    }

    public static void println(String s)
    {
        System.out.println(s);



    }

    public static void main(String[] args) {
        System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
    }




}
