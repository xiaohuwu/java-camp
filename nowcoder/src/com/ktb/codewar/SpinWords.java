package com.ktb.codewar;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SpinWords {

    public static void main(String[] args) {
        String hey_fellow_warriors = new SpinWords().spinWords("Hey fellow warriors");
        System.out.println("res:"+ hey_fellow_warriors);
    }

    public String spinWords(String sentence) {
//        String[] split = sentence.split("\\s+");
//        for (String s : split) {
//            if (s.length() >= 5) {
//                List<String> strings = Arrays.asList(s.split(""));
//                Collections.reverse(strings);
//                s = strings.stream().collect(Collectors.joining(""));
//            }
//        }
//        return String.join(" ",split);


        return Arrays.stream( sentence.split(" ") )
                .map( w -> w.length() < 5 ? w : new StringBuilder(w).reverse().toString() )
                .collect(Collectors.joining(" "));
    }




}

