package com.ktb.java1;

import org.junit.*;

import java.util.Comparator;


public class LambdaTest {

    @Test
    public void test1() {
        Runnable test = () -> {
            System.out.println("我爱北京天安门");
        };
        test.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);
        int compare = comparator.compare(2, 3);
        System.out.println("compare = " + compare);

        Comparator<Integer> comparator3 = Integer::compareTo;
        int compare1 = comparator3.compare(3, 4);
        System.out.println("compare1 = " + compare1);
    }





}
