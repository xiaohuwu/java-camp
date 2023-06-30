package com.ktb.codewar;

import java.util.Arrays;

public class SquareDigit {

    public static void main(String[] args) {
        System.out.println(new SquareDigit().squareDigits(9119) == 811181);
    }
    public int squareDigits(int n) {
        String[] split = String.valueOf(n).split("");
        String[] objects = Arrays.stream(split).map((item) -> String.valueOf(Integer.parseInt(item) * Integer.parseInt(item))).toArray(size ->  new String[size]);
        return  Integer.valueOf(String.join("",objects));
    }
}
