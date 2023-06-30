package com.ktb.leetcode.array;

import java.util.Arrays;

//删除排序数组中的重复项
public class Array1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println("nums = " + Arrays.toString(nums));
        int i = removeDuplicates(nums);
        System.out.println("i = " + i);
    }

    public static int removeDuplicates(int[] nums) {
        int index_before = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index_before] != nums[i]) {
                index_before++;
                nums[index_before] = nums[i];
            }
        }
        return ++index_before;
    }

}
