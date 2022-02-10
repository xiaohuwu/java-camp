package com.ktb.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/submissions/
 */

public class MaxSumInArray {
    public static void main(String[] args) {
//        int[] nums = new int[]{-2, 1};
//        int i = maxSubArray(nums);
//        System.out.println("i = " + i);
        int pwwkew = maxSubArray("pwwkew");
        System.out.println("pwwkew = " + pwwkew);
    }
    public static int maxSubArray(String s) {
        if(s.length() ==0){
            return 0;
        }
        int max_sum = 1;
        for (int i = 0; i < s.length(); i++) {
            String sub = String.valueOf(s.charAt(i));
            for (int k = i + 1; k < s.length(); k++) {
                String item = String.valueOf(s.charAt(k));
                if (sub.indexOf(item) == -1) {
                    sub += item;
                    if (sub.length() > max_sum) {
                        max_sum = sub.length();
                    }
                } else {
                    break;
                }
            }
        }
        return max_sum;
    }


}
