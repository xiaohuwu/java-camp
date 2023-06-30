package com.ktb.sort;

import java.util.Arrays;

//doc/select_sort

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {6, 7, 8, 9, 4, 5, 3, 2, 1};
        //选择排序
        array = select_sort(array);
        System.out.println("选择排序");
        System.out.println(Arrays.toString(array));
    }

    private static int[] select_sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int k = i + 1; k < array.length; k++) {
                if (array[k] <  array[i]) {
                    int temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
            }
        }
        return array;
    }

}
