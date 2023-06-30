package com.ktb.lambda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda 表达式 本质是匿名对象
 */

public class Test1 {

    /**
     *第一种 无参无返回
     */
    @Test
    public void test1(){
        Runnable runnable = ()->{
            System.out.println("hello world");
        };
        runnable.run();
    }

    /**
     *第2种 有参无返回
     */
    @Test
    public void test2(){
       Consumer<String> consumer = new Consumer<String>() {
           @Override
           public void accept(String  o) {
               System.out.println("result: "+ o);
           }
       };
        consumer.accept("一个人说听的当真");
        System.out.println("******************************");

        Consumer<String> consumer1 = (String param)->{
            System.out.println("param: "+ param);
        };
        consumer1.accept("一个人说听的当真");
        System.out.println("******************************");
        Consumer<String> consumer3=  System.out::println;
        consumer3.accept("一个人说听的当真");

    }

    /**
     *第3种 有参有返回
     */
    @Test
    public void test4(){
        Consumer<String> consumer1 = (param)->{
            System.out.println("param: "+ param);
        };
        consumer1.accept("一个人说听的当真");
    }


    @Test
    public void test5(){
        Consumer<String> consumer1 = param-> System.out.println("param: "+ param);
        consumer1.accept("一个人说听的当真");
    }

    @Test
    public void test6(){
        Comparator<Integer> comparator = (o1, o2) ->  o1.compareTo(o2);
        int compare = comparator.compare(3, 4);
    }

    @Test
    public void test7(){
        Consumer<String> consumer1 = (param)-> System.out.println("param: "+ param);
        consumer1.accept("一个人说听的当真");
    }




}
