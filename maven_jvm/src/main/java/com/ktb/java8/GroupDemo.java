package com.ktb.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {{
            add("1");
            add("2");
            add("2");
        }};

        Map<String, List<String>> strList = list.stream().collect(Collectors.groupingBy(s -> {
            if("2".equals(s)) {
                return "2";
            }else {
                return "1";
            }
        }));

        strList.forEach((key,val)->{
            System.out.println("key = " + key);
            System.out.println("val = " + val);
        });
    }

}
