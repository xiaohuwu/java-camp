package com.ktb.springbootdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
////lambda表达式使用：
//        Arrays.asList(new String[]{"a", "c", "b"}).stream().forEach(s -> {
//            int res = 1+1;
//            Test4.println(s);
//        });
//        //静态方法引用：
//        Arrays.asList(new String[]{"a", "c", "b"}).stream().forEach(Test4::println);
//
//        //构造方法引用
//        Supplier<List<String>> supplier= () -> new  ArrayList<String>();
//        Supplier<List<String>> supplier1= ArrayList<String>::new;


        int[] intArray = {1, 2, 3, 4, 5};

        // 1. Arrays.stream -> IntStream
//        IntStream intStream1 = Arrays.stream(intArray);
//        intStream1.forEach(x -> System.out.println(x));

        // 2. Stream.of -> Stream<int[]>
        Stream<int[]> temp = Stream.of(intArray);

        // Cant print Stream<int[]> directly, convert / flat it to IntStream
//        IntStream intStream2 = temp.flatMapToInt(x -> Arrays.stream(x));
//        temp.forEach(x -> System.out.println(x));


//        List<String> list = Arrays.asList("a", "Vb", "c");
//        list.stream()
//                .filter(e -> e.startsWith("V"))
//                .findFirst()
//                .ifPresent((item) -> System.out.println(item));

        List<String> list = List.of("apple", "pear", "banana");
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        collect.stream().forEach(System.out::println);

    }


    public static void println(String s) {
        System.out.println(s);
    }
}
