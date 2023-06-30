package com.ktb.lambda;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 方法引用 -->lambda表达式的简写
 *
 * 方法引用的使用
 * 1.使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 *   方法引用，也是函数式接口的实例。
 * 3. 使用格式：  类(或对象) :: 方法名
 * 4. 具体分为如下的三种情况：
 *    情况1     对象 :: 非静态方法
 *    情况2     类 :: 静态方法
 *
 *    情况3     类 :: 非静态方法
 *
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 *    形参列表和返回值类型相同！（针对于情况1和情况2）
 *
 * Created by shkstart.
 */
public class MethodRefTest {
    /**
     *  void accept(T t);
     *  void println(String x)
     */
    @Test
    public void test1(){
        Consumer<String> con1 = str ->{
            System.out.println(str);
        };
        con1.accept("good");
        System.out.println("*****************************");
        PrintStream out = System.out;
        Consumer<String> con2 = out::println;
        con2.accept("好");
    }

    @Test
    public void test2(){
         Function<Integer,String[]> func1 = length ->{
           return   new String[length];
         };
        String[] apply = func1.apply(4);
        System.out.println(Arrays.toString(apply));
        System.out.println("*****************************");
        Function<Integer,String[]> function = String[]::new;
        String[] apply1 = function.apply(6);
        System.out.println(Arrays.toString(apply1));
    }

}
