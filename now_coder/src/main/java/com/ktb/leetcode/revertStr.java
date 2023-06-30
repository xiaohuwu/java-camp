package com.ktb.leetcode;

import java.util.Arrays;

/**
 * 反转字符串
 * <p>
 * s = ["h","e","l","l","o"]
 */
public class revertStr {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l'};
        reverseString(s);
        System.out.println("s = " + Arrays.toString(s));
    }


    public static void reverseString(char[] str) {
        int minddle = str.length / 2;
        for (int i = 0; i < minddle; i++) {
            char temp = str[i];
            str[i] = str[str.length - i - 1];
            str[str.length - i - 1] = temp;
        }
    }

}
