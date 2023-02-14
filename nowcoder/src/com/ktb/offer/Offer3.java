package com.ktb.offer;

public class Offer3 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,0,2,5,3};
        int num = duplicate(arr);
        System.out.println("num = " + num);
    }


    public static int duplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return  nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
