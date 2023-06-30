package com.ktb.sort;

import java.util.Arrays;

public class BasicSort {

    public static void main(String[] args) {
        int[] array = {6, 7, 8, 9, 4, 5, 3, 2, 1};
        //冒泡排序
        array = bubbleSort(array);
        System.out.println("冒泡排序");
        System.out.println(Arrays.toString(array));

        int[] select_array = {6, 7, 8, 9, 4, 5, 3, 2, 1};
        //选择排序
        select_array = selectSort(select_array);
        System.out.println("选择排序");
        System.out.println(Arrays.toString(select_array));

        //插入排序
        int[] insert_array = {6, 7, 8, 9, 4, 5, 3, 2, 1};
        insert_array = insertSort(insert_array);
        System.out.println("插入排序");
        System.out.println(Arrays.toString(insert_array));
    }

    // this is my answer
    public static int[] insertSort(int[] array) {
        for (int index = 1; index < array.length; index++) {
            int currentItem = array[index];
            int j = index - 1;
            for (; j >= 0; j--) {
                int itemJ =  array[j];
                if (currentItem < itemJ) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            j++; //这一步容易忽略  最后一次  array[j + 1] = array[j]; 后J的索引就是需要插值的地方 后来又 j-- 了 所以需要加回来
            array[j] = currentItem;
           // System.out.println("临时结果: " + Arrays.toString(array));
        }
        return array;
    }

    //冒泡排序
    public static int[] bubbleSort(int[] array) {
        for (int row = 0; row < array.length; row++) {
            for (int j = 0; j < array.length - row - 1; j++) {  //array.length - row - 1 这个容易算错
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }


    //选择排序
    public static int[] selectSort(int[] array) {
        for (int index = 0; index < array.length; index++) {
            int min_index = index;
            for (int k = index + 1; k < array.length; k++) {
                if (array[min_index] > array[k]) { //这一步是易错点 最小值对应的下标，相应的值也应该是最小的
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
