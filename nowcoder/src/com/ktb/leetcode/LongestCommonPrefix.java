package com.ktb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"cir", "car"};
        String s = longestCommonPrefix(strs);
        System.out.println("s = " + s);
    }

    public static String longestCommonPrefix(String[] strs) {
        List<String> list = new ArrayList<String>();
        int min = Arrays.stream(strs).map(String::length).min(Integer::compareTo).get();
        for (int k = 0; k < min; k++) {
            boolean is_eq = true;
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(k) != (strs[i + 1].charAt(k))) {
                    is_eq = false;
                    break;
                }
            }
            if (is_eq) {
                list.add(String.valueOf(strs[0].charAt(k)));
            } else {
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s);
        }
        return result.toString();
    }

}
