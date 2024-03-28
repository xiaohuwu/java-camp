package com.example.xuefeng.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Demo1 {
    public static void main(String[] args) {


        Stream<String> stream = Arrays.stream(new String[]{"1", "2", "3"});
        stream.forEach(System.out::println);

        List<String> of = Arrays.asList("hello", "world");
        of.stream().forEach(System.out::println);


        IntStream is = Arrays.stream(new int[]{1, 2, 3});
        // 将Stream<String>转换为LongStream:
        LongStream ls =  Arrays.asList("1", "2", "3").stream().mapToLong(Long::parseLong);
        ls.forEach(System.out::println);


        System.out.println("\"================\" = " + "================");
        Stream<String> a = Stream.of("A", "B", "C");
        a.peek(System.out::println).map((item) -> item + item).forEach((item) -> {
            System.out.println("====>" + item);
        });



    }
}
