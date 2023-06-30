package com.ktb.codewar;

public class SecureTester {


    public static boolean alphanumeric(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int temp = (int) aChar;
            if ((temp >= 48 && temp <= 57) || (temp >= 65 && temp <= 90) || (temp >= 97 && temp <= 122)){
                continue;
            }else{
                System.out.println("aChar " + String.valueOf(aChar));
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "0123456789";
        boolean alphanumeric = alphanumeric(test);
        System.out.println("alphanumeric = " + alphanumeric);
    }

}
