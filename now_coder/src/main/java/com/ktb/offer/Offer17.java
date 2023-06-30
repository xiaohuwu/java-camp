package com.ktb.offer;

import java.util.Arrays;

//https://leetcode.cn/leetbook/read/illustrate-lcof/xzvgc2/
public class Offer17 {
    public static void main(String[] args) {
        int[] ints = printNumbers(3);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    public static int[] printNumbers(int n) {
        int v = (int) (Math.pow(10, n) - 1);
        int k = 1;
        int[] result = new int[v];
        while (k <= v) {
            result[k - 1] = k;
            k++;
        }
        return result;
    }

}
