package com.ktb.lambda;


import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * lambda 表达式 本质是匿名对象
 * 消费型接口
 * Consumer<T>
 * T get()
 * R apply(T)
 * void predicate(T)
 * 因为函数式接口 所以用lambda表达式
 */

public class Test2 {


    @Test
    public void test1() {
        happTime(200, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("I am very happy for get " + aDouble);
            }
        });
        System.out.println("****************************************");
        happTime(400, money -> System.out.println("I am very happy for get " + money));


        System.out.println("****************************************");

        List<String> list = Arrays.asList("1", "2", "3", "4");
        List<String> strings = filterStringList(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("3");
            }
        });
        System.out.println("strings:" + strings);
        List<String> strings1 = filterStringList(list, s -> s.equals("3"));
        System.out.println("strings1:" + strings1);

    }


    public void happTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    public List<String> filterStringList(List<String> list, Predicate<String> predicate) {
        ArrayList<String> filterList = new ArrayList<>();
        list.forEach(e -> {
            if (predicate.test(e)) {
                filterList.add(e);
            }
        });
        return filterList;
    }

}
