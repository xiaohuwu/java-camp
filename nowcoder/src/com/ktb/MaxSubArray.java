package com.ktb;

import java.util.Arrays;
//https://leetcode-cn.com/problems/maximum-subarray/ 花了 30 分钟左右 运行时间超时了
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1};
        int ints = maxSubArray(nums);
        System.out.println(ints);
    }

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (item > sum) {
                sum = item;
            }
            for (int j = 1; j < nums.length - i; j++) {
                item += nums[i + j];
                if (item > sum) {
                    sum = item;
                }
            }
        }
        return sum;
    }
}
