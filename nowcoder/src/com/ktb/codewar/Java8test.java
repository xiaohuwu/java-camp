package com.ktb.codewar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8test {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Lord of the rings"),
                new Movie("Back to the future"),
                new Movie("Carlito's way"),
                new Movie("Pulp fiction"));

        movies.forEach(System.out::println);
    }
}
