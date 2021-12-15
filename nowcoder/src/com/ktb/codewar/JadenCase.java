package com.ktb.codewar;

import java.util.Arrays;

public class JadenCase {


    public static void main(String[] args) {
        JadenCase jadenCase = new JadenCase();
        String s = jadenCase.toJadenCase("most trees are blue");
        System.out.println("s567:" + s);
        System.out.println("res:" + ("Most Trees Are Blue".equals(s)));

    }


    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) return null;
        String[] jadenCaseString = Arrays.stream(phrase.split("\\s+")).map(str -> Character.toUpperCase(str.charAt(0)) + str.substring(1))
                .toArray(size ->  new String[size] );
        return String.join(" ", jadenCaseString);
    }

}
