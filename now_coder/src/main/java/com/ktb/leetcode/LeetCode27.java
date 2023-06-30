package com.ktb.leetcode;

public class LeetCode27 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int i = removeElement(nums, 3);
        System.out.println("i = " + i);
    }


//    public static int removeElement(int[] nums, int val) {
//        int size = nums.length;
//        for (int i = 0; i < size; i++) {
//            if (nums[i] == val) {
//                for (int j = i; j < size - 1; j++) {
//                    nums[j] = nums[j + 1];
//                }
//                i--;
//                size--;
//            }
//        }
//        return size;
//    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                left++;
            }
        }
        return left;
    }


}
