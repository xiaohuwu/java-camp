package com.ktb.codewar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {


    public static List<String> singlePermutations(String s) {
        String[] split = s.split("");
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < split.length; i++) {
            String item = split[i];
            List<Integer> usedList = new ArrayList<Integer>();
            usedList.add(i);
            List<String> subStr =  getSubString(usedList, split);
            item += subStr;
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    private static  List<String> getSubString(List usedList, String[] split) {
        for (int i = 0; i < split.length; i++) {
            String item = split[i];
            List<String> subStr =  getSubString(usedList, split);
        }
        return null;
    }

}
