package com.sangeng;

import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//
///**
// * Unit test for simple App.
// */
public class AppTest {
    public static void main(String[] args) {
        int i = test1(3, 4);
        System.out.println("i = " + i);
    }

    public static int test1(int a, int b) {
        return test2(a, b);
    }

    private static int test2(int a, int b) {
        return a + b;
    }
}
