package com.ktb.offer;

import java.util.Arrays;


//https://leetcode.cn/leetbook/read/illustrate-lcof/xz0lse/
public class ChangeOrder {


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        int[] exchange = exchange(array);
        System.out.println("Arrays.toString(exchange) = " + Arrays.toString(exchange));
    }

    private static int[] exchange(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while ( start < end && array[start] % 2 == 1) {
                start++;
            }
            while (start < end &&  array[end] % 2 == 0) {
                end--;
            }
            mySwap(array, start, end);
        }
        return array;
    }

    private static void mySwap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

}
