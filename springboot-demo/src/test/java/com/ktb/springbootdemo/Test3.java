package com.ktb.springbootdemo;

import org.junit.jupiter.api.Test;

public class Test3 {

    @FunctionalInterface
    public interface ImTheOne {
        String handleString(String a, String b);
    }

    /**
     * 简单的Lambda表达式的例子
     */
    @Test
   public void test1(){
        ImTheOne theOne = (String a, String b) -> a + b;
        String result = theOne.handleString("abc", "def");
        System.out.println(result);
   }

    /**
     * 类::静态方法 如果方法的入参个数和返回值 和 函数式接口的入参和返回值相同 就可以采用 方法引用
     */
    @Test
    public void test2(){
        ImTheOne theOne = OneClass::concatString;
        String result = theOne.handleString("abc", "def");
        System.out.println(result);
    }

    /**
     * 实例对象::对象方法 如果方法的入参个数和返回值 和 函数式接口的入参和返回值相同 就可以采用 方法引用
     */
    @Test
    public void test3(){
        ImTheOne theOne = new OneClass()::concatStringOther;
        String result = theOne.handleString("abc", "def");
        System.out.println(result);
    }



}


class OneClass {

    public static String concatString(String a, String b) {
        return a + b;
    }

    public  String concatStringOther(String a, String b) {
        return a + b;
    }

}
