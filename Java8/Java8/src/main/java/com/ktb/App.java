package com.ktb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String args[]) throws IOException {

        // Setting up collection class
        final int MAX_ORDERS = 50000000; // 50 mn integers
        List<Integer> values = new ArrayList<>(MAX_ORDERS);
        Random rand = new Random(System.nanoTime());
        for (int i = 0; i < MAX_ORDERS; i++) {
            Integer number = rand.nextInt();
            values.add(number);
        }

        // Starting sequential filtering
        long startTime = System.nanoTime();

        long count = values.stream().filter(i -> i % 31 == 0).count();
        // long count = values.stream().sorted().count();
        //uncomment to test sorting
        System.out.println(count);

        long endTime = System.nanoTime();

        long timeTakenInMillis = TimeUnit.NANOSECONDS
                .toMillis(endTime - startTime);
        System.out.println(String.format("Sequential filtering took: %d ms",
                timeTakenInMillis));


        // Starting parallel filtering of Collection
        long start = System.nanoTime();

        long count1 = values.parallelStream().filter(i -> i % 31 == 0).count();
        // long count1 = values.parallelStream().sorted().count();
        //uncomment to test sorting
        System.out.println(count1);

        long end = System.nanoTime();

        long elapsed = TimeUnit.NANOSECONDS.toMillis(end - start);
        System.out.println(String.format("parallel filtering took: %d ms",
                elapsed));

    }
}
