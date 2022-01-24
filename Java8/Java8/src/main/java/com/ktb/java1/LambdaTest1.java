package com.ktb.java1;

import com.ktb.java2.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

//方法引用是lamda 表达式的简写形式


/**
 * 方法引用的使用
 *
 * 1.使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 *   方法引用，也是函数式接口的实例。
 *
 * 3. 使用格式：  类(或对象) :: 方法名
 *
 * 4. 具体分为如下的三种情况：
 *    情况1     对象 :: 非静态方法
 *    情况2     类 :: 静态方法
 *
 *    情况3     类 :: 非静态方法
 *
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 *    形参列表和返回值类型相同！（针对于情况1和情况2）
 *
 */
public class LambdaTest1 {

    @Test
    public void test1() {
        Consumer<String> consumer = (String t) -> {
            System.out.println("t = " + t);
        };
        consumer.accept("good study");
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("一个人说听的当真");
    }


    @Test
    public void test2() {
        Employee employee = new Employee(1001, "Tomcat", 100, 5600);
        Supplier<String> supplier = () -> employee.getName();
        System.out.println("supplier = " + supplier.get());

        //等价上面的写法
        Supplier<String> supplier1 = employee::getName;
        System.out.println("supplier1 = " + supplier1.get());

    }

    @Test
    public void test4() {
        Function<Double,Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };

        System.out.println("*******************");

        Function<Double,Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));

        System.out.println("*******************");

        Function<Double,Long> func2 = Math::round;
        System.out.println(func2.apply(12.6));
    }







}
