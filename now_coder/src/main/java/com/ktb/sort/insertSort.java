package com.ktb.sort;

import java.util.Arrays;

//doc/insert_sort

public class insertSort {
    public static void main(String[] args) {
        int[] array = {3, 4, 6, 7, 2, 7, 2, 8, 0};
        //选择排序
        array = inset_sort(array);
        System.out.println("插入排序");
        System.out.println(Arrays.toString(array));
    }

    private static int[] inset_sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (array[j] < array[j -1]) {
                    swap(array, j, j - 1);
                }
            }
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
