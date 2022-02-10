package com.ktb.springbootdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Test4 {
    public static void main(String[] args) {
////lambda表达式使用：
//        Arrays.asList(new String[]{"a", "c", "b"}).stream().forEach(s -> {
//            int res = 1+1;
//            Test4.println(s);
//        });
//        //静态方法引用：
//        Arrays.asList(new String[]{"a", "c", "b"}).stream().forEach(Test4::println);
//
//        //构造方法引用
//        Supplier<List<String>> supplier= () -> new  ArrayList<String>();
//        Supplier<List<String>> supplier1= ArrayList<String>::new;


        for (int i = 0; i < 7; i++) {
            System.out.println("i:" + i);
        }
    }


    public static void println(String s) {
        System.out.println(s);
    }
}
