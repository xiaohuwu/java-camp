package com.ktb.java8;

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calculator = (int a, int b) -> {

            return a + b;
        };

        int add = calculator.add(1, 2);
        System.out.println("add = " + add);
    }
}
