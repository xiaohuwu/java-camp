package com.ktb.sort;

import java.util.Arrays;

public class BasicSort {

    public static void main(String[] args) {
        int[] array = {6, 7, 8, 9, 4, 5, 3, 2, 1};
//        //冒泡排序
//        array = bubbleSort(array);
//        System.out.println("冒泡排序");
//        System.out.println(Arrays.toString(array));
//
//        int[] select_array = {6, 7, 8, 9, 4, 5, 3, 2, 1};
//        //选择排序
//        select_array = selectSort(select_array);
//        System.out.println("选择排序");
//        System.out.println(Arrays.toString(select_array));

        //插入排序
        int[] insert_array = {6, 7, 8, 9, 4, 5, 3, 2, 1};
        insert_array = insertSort(insert_array);
        System.out.println("插入排序");
        System.out.println(Arrays.toString(insert_array));
    }

    //冒泡排序
    public static int[] bubbleSort(int[] array) {
        for (int row = 0; row < array.length; row++) {
            for (int j = 0; j < array.length - row - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] insertSort(int[] array) {
        for (int index = 1; index < array.length; index++) {
            int currentItem = array[index];
            int j = index;
            for (; j > 0; j--) {
                if (currentItem < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j] = currentItem;
            System.out.println("临时结果: " + Arrays.toString(array));
        }
        return array;
    }

    //选择排序
    public static int[] selectSort(int[] array) {
        for (int index = 0; index < array.length; index++) {
            int min_index = index;
            for (int k = index + 1; k < array.length; k++) {
                if (array[min_index] > array[k]) {
                    min_index = k;
                }
            }
            if (min_index != index) {
                int temp = array[index];
                array[index] = array[min_index];
                array[min_index] = temp;
            }
        }
        return array;
    }

}
