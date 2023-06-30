package com.ktb.codewar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JadenCase {


    public static void main(String[] args) {
        Movie one = new Movie("one");
        Movie two = new Movie("two");
        Movie three = new Movie("three");
        Movie four = new Movie("four");

        List<Movie> list = Arrays.asList(one, two, three, four);
        List<Movie> collect = list.stream().distinct().collect(Collectors.toList());
        collect.forEach((item) -> {
            System.out.println("item = " + item);
        });

//
//        int[] numbers = {5, 5, 4, 3, 1, 4, 5, 4, 5};
//        int[] noDuplicates = IntStream.of(numbers).distinct().toArray();
    }


    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) return null;
        String[] jadenCaseString = Arrays.stream(phrase.split("\\s+")).map(str -> Character.toUpperCase(str.charAt(0)) + str.substring(1))
                .toArray(size -> new String[size]);
        return String.join(" ", jadenCaseString);
    }

}
