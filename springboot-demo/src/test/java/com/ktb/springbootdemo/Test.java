package com.ktb.springbootdemo;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import net.minidev.json.JSONUtil;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.jupiter.api.*;

public class Test {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
     *  *    形参列表和返回值类型相同！（针对于情况1和情况2）
     */
    @org.junit.jupiter.api.Test
    public void test1(){
        Consumer<String> test = new Consumer<String>(){

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        test.accept("6666");
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");

        System.out.println("*******************");

        PrintStream ps = System.out;
        Consumer<String> con2 = System.out::println;
        con2.accept("beijing");

    }


    //Supplier中的T get()
    //Employee中的String getName()
    @org.junit.jupiter.api.Test
    public void test2() {
        Employee emp = new Employee(1001, "Tom", 23, 5600);

        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        System.out.println("*******************");
        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }


    @org.junit.jupiter.api.Test
    public void test3() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        Consumer consumer = System.out::println;
        strings.forEach(consumer);
    }



}
