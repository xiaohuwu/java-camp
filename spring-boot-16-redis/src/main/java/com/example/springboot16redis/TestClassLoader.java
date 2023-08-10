package com.example.springboot16redis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClassLoader {
   protected   static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) {
                list.remove(i);
            }
        }
        list.forEach(System.out::println);


        ExecutorService executor = Executors.newFixedThreadPool(10);

        int[] array = {1, 2, 3};
        List list1 = Arrays.asList(array);
        System.out.println(list1.size());
    }
}
