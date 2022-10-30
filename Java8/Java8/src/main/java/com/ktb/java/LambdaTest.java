package com.ktb.java;

import org.junit.*;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


public class LambdaTest {

    @Test
    public void test1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println("format = " + format);
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
