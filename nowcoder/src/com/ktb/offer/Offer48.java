package com.ktb.offer;

public class Offer48 {

    public static void main(String[] args) {
        String str = "pwwkew";
        int count = getMaxSubString(str);
        System.out.println("count = " + count);
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
                }else{
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
