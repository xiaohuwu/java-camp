package com.ktb.codewar;

import java.util.*;
import java.util.stream.Collectors;

public class DescendingOrder {
    public static void main(String[] args) {
        DescendingOrder order = new DescendingOrder();
        int i = order.sortDesc(42145);
        System.out.println("i:"+i);
    }

    public  int sortDesc(final int num) {
        String[] split = String.valueOf(num).split("");
        List<String> strings = Arrays.asList(split);
        Collections.sort(strings, (o1, o2) -> {
            int result = Integer.parseInt(o1) - Integer.parseInt(o2);
            return result > 0 ? -1 : (result < 0 ? 1 : 0);
        });
       String rest =  strings.stream().collect(Collectors.joining(""));
       return Integer.parseInt(rest);
    }
}
