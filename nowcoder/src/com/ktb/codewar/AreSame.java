package com.ktb.codewar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AreSame {


    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 3};
        int[] b = new int[]{4, 9, 9};
        System.out.println("a:" + Arrays.toString(a));
        System.out.println("b:" + Arrays.toString(b));
        boolean comp = comp(a, b);
        System.out.println("comp:" + comp);
    }

    public static boolean comp(int[] a, int[] b) {
        if (b == null || a.length != b.length) {
            return false;
        }
        List<Integer> b_list = Arrays.stream(b).boxed().collect(Collectors.toList());
        List<Integer> a_list = Arrays.stream(a).boxed().collect(Collectors.toList());
        boolean is_container = true;
        for (Integer k : a_list) {
            Integer item = k * k;
            boolean b1 = b_list.stream().anyMatch((j) -> item.equals(j));
            if (b1) {
                b_list.remove(item);
            } else {
                is_container = false;
                break;
            }
        }
        return is_container;
    }
}
