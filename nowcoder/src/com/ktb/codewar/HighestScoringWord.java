package com.ktb.codewar;

public class HighestScoringWord {

    public static void main(String[] args) {
        String high = high("man i need a taxi up to ubud");
        System.out.println("high:"+high);
    }

    public static String high(String s) {
        String[] split = s.split("\\s");
        String word = split[0];
        int sum = getSum(split[0].toCharArray());
        for (int i = 0; i < split.length; i++) {
            char[] chars = split[i].toCharArray();
             if(getSum(chars) > sum){
                 word = split[i];
                 sum = getSum(chars);
             }
        }
        return word;
    }

    private static int  getSum(char[] chars) {
        int  sum = 0;
        for (char aChar : chars) {
             sum += aChar - 'a' + 1;
        }
        return sum;
    }


}
