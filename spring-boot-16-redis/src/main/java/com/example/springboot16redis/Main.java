package com.example.springboot16redis;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        Stream<String> stream1 = Arrays.stream(new String[]{"A", "B", "C"});
        stream1.forEach(System.out::println);
        Stream<Integer> integerStream = Stream.of(1, 2, 4, 5);
        Stream<Integer> integerStream1 = integerStream.map((item) -> item * item);
        integerStream1.forEach(System.out::println);
    }


}
