package com.ktb.leetcode;

//https://leetcode.cn/leetbook/read/array-and-string/conm7/

import com.ktb.leetcode.otherlinklist.Solution;

public class LongestPalindrome {
    public static void main(String[] args) {
        String testStr = "ac";
        String babad = longestPalindrome1(testStr);
        System.out.println("ac = " + babad);
    }

    public static String longestPalindrome(String s) {
        if (s.length() % 2 == 1) {
            String[] split = s.split("");
            if (split.length == 1) {
                return s;
            }
            String result = "";
            for (int i = 1; i < split.length; i++) {
                for (int k = 0; k <= i; k++) {
                    if (i - k < 0 || i + k >= s.length()) {
                        continue;
                    }
                    if (split[i + k].equals(split[i - k])) {
                        continue;
                    } else {
                        int start_index = i - k + 1;
                        int end_index = i + k - 1;
                        String substring = s.substring(start_index, end_index + 1);
                        if (substring.length() > result.length()) {
                            result = substring;
                        }
                    }
                }
            }
            return result;
        }else {
            int i = 0, j = 0;
            for (int k = 1; k < s.length(); k++) {
                int  i0 = k, j0 = k - 1;//偶数回文
                while (i0 > 0 && j0 < s.length() - 1) {
                    if (s.charAt(i0 - 1) == s.charAt(j0 + 1)) {
                        i0--;
                        j0++;
                    } else break;
                }
                if (j0 - i0 > j - i) {
                    i = i0;
                    j = j0;
                }
            }
            return s.substring(i, j  + 1);
        }

    }



    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
