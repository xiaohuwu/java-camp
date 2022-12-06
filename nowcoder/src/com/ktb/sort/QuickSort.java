package com.ktb.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,2,4,8,1,3,7};
        QuickSort(arr, 0, arr.length - 1);
        System.out.println("arr = " + Arrays.toString(arr));
    }


    /**
     * https://blog.csdn.net/weixin_50886514/article/details/119045154
     * 1、选出一个key，一般是最左边或是最右边的。
     * 2、定义一个begin和一个end，begin从左向右走，end从右向左走。（需要注意的是：若选择最左边的数据作为key，则需要end先走；若选择最右边的数据作为key，则需要bengin先走）。
     * 3、在走的过程中，若end遇到小于key的数，则停下，begin开始走，直到begin遇到一个大于key的数时，将begin和right的内容交换，end再次开始走，如此进行下去，直到begin和end最终相遇，此时将相遇点的内容与key交换即可。（选取最左边的值作为key）
     * 4.此时key的左边都是小于key的数，key的右边都是大于key的数
     * 5.将key的左序列和右序列再次进行这种单趟排序，如此反复操作下去，直到左右序列只有一个数据，或是左右序列不存在时，便停止操作，此时此部分已有序
     */
    //快速排序   hoare版本(左右指针法)
    public static void QuickSort(int[] arr, int begin, int end) {
        //只有一个数或区间不存在
        if (begin >= end) return;
        int left = begin;
        int right = end;
        //选左边为key
        int keyi = begin;
        while (begin < end) {
            //右边选小   等号防止和key值相等    防止顺序begin和end越界
            while (arr[end] >= arr[keyi] && begin < end) {
                --end;
            }
            //左边选大
            while (arr[begin] <= arr[keyi] && begin < end) {
                ++begin;
            }
            //小的换到右边，大的换到左边
            swap(arr, begin, end);
        }
        swap(arr, keyi, end); //基准点 和 最后找到的坐标 互换。
        keyi = end; //最后以 end 坐标做拆分，递归左右两边的子数组
        QuickSort(arr, left, keyi - 1);
        QuickSort(arr, keyi + 1, right);
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }


}
