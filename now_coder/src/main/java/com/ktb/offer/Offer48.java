package com.ktb.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer48 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        int count = lengthOfLongestSubstring(str);
        System.out.println("count = " + count);
    }


    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = end;
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return ans;
    }

    private static int getMaxSubString(String str) {
        char[] chars = str.toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            String temp = String.valueOf(chars[i]);
            for (int k = i + 1; k < chars.length; k++) {
                String aChar = String.valueOf(chars[k]);
                if (!temp.contains(aChar)) {
                    temp += aChar;
                } else {
                    break;
                }
            }
            if (temp.length() > result.length()) {
                result = temp;
            }
        }
        return result.length();
    }


}
