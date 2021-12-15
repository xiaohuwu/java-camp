package com.ktb.codewar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EnoughIsEnough {
    public static void main(String[] args) {
        int[] test_a  = new int[]{10, 0, 23, 10, 9, 0, 19, 19, 15, 19, 19, 14, 11, 4, 27, 22, 21, 7, 9, 6, 24, 27, 10, 12, 5, 24, 6, 13};
        int[] ints = deleteNth(test_a, 0);

        System.out.println("ints:" + Arrays.toString(ints));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        List<Integer> b_list = Arrays.stream(elements).boxed().collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();
        HashMap<Integer, Integer> checkHash = new HashMap<Integer, Integer>();
        for (Integer integer : b_list) {
            if (checkHash.containsKey(integer)) {
                Integer count = checkHash.get(integer);
                count++;
                checkHash.put(integer, count);
            } else {
                checkHash.put(integer, 1);
            }
            if (checkHash.get(integer) <= maxOccurrences) {
                resultList.add(integer);
            }
        }
        return resultList.stream().mapToInt(i->i).toArray();
    }

    public static int[] deleteNth_teacher(int[] elements, int max) {

        if (max < 1) return new int[0];

        final HashMap<Integer,Integer> map = new HashMap<>();
        final List<Integer> list = new ArrayList<>();

        for (final Integer i : elements) {
            final Integer v = map.put(i, map.getOrDefault(i, 0) + 1);
            if (v == null || v < max) list.add(i);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
