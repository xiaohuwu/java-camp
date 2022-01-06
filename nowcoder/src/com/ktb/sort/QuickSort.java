package com.ktb.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7, 2, 7, 2, 8, 0};
        sorted(arr,0,arr.length -1);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void sorted(int[] arr, int start, int end) {
           if(start < end){
               int low = start;
               int high = end;
               int stard = arr[start];
               while (low < high) {
                   while (low < high && arr[high] >= stard ){
                       high--;
                   }
                   arr[low] = arr[high];
                   while (low < high && arr[low] <= stard ){
                       low++;
                   }
                   arr[high] = arr[low];
               }
               arr[low] = stard;
               System.out.println("arr = " + Arrays.toString(arr));
               sorted(arr,0,low);
               sorted(arr,low+1,end);
           }
    }


}
