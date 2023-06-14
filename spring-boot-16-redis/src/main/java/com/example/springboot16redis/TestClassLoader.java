package com.example.springboot16redis;

import java.util.ArrayList;

public class TestClassLoader {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
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

    }
}
