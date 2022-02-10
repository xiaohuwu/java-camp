package com.ktb.leetcode;

public class MaxSumInArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1};
        int i = maxSubArray(nums);
        System.out.println("i = " + i);
    }

    public static int maxSubArray(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int k = i ; k < nums.length; k++) {
                sum  +=  nums[k];
                if(sum > max_sum){
                    max_sum = sum;
                }
            }
        }
        return max_sum;
    }




}
