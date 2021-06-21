package com.ktb;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * 尚硅谷 Java 函数式编程
 */

public class Test1 {

    @Test
    public void test1(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("this is runnable");
            }
        };
        runnable.run();
    }

    @Test
    public void test2(){
      Comparator<Integer> comparator = new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
              return o1 - o2;
          }
      };
        int compare = comparator.compare(3, 4);
        System.out.println("compare:  "+compare);

        System.out.println("******************************");
        Comparator<Integer> comparator1 = Comparator.comparingInt(o -> o);
        System.out.println("comparator1:  "+comparator1.compare(4,5));

        System.out.println("******************************");
        Comparator<Integer> comparator2 = Integer::compareTo;
        System.out.println("comparator1:  "+ comparator2.compare(5, 6));
    }

}
