package com.ktb.codewar;

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {
    public static void main(String[] args) {
        long[] longs = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Long> longs1 = sumDigPow(1, 100);
        System.out.println("long1:");
        longs1.forEach(System.out::println);
    }

    public static List<Long> sumDigPow(long a, long b) {
        ArrayList<Long> result = new ArrayList<Long>();
        for (long k = a; k <= b; k++) {
            if (full_number(k)) {
                result.add(k);
            }
        }
        return result;
    }

    private static boolean full_number(long k) {
        String s = String.valueOf(k);
        String[] s_array = s.split("");
        long sum = 0;
        for (int i = 0; i < s_array.length; i++) {
            sum += Math.pow(Long.parseLong(s_array[i]), i + 1);
        }
        return sum == k;
    }

}
