package com.ktb.java1;

import com.ktb.java2.Employee;
import com.ktb.model.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;
//方法引用是lamda 表达式的简写形式

/**
 * 方法引用的使用
 * <p>
 * 1.使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * <p>
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 * 方法引用，也是函数式接口的实例。
 * <p>
 * 3. 使用格式：  类(或对象) :: 方法名
 * <p>
 * 4. 具体分为如下的三种情况：
 * 情况1     对象 :: 非静态方法
 * 情况2     类 :: 静态方法
 * <p>
 * 情况3     类 :: 非静态方法
 * <p>
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 * 形参列表和返回值类型相同！（针对于情况1和情况2）
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
        Function<Double, Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };

        System.out.println("*******************");

        Function<Double, Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));

        System.out.println("*******************");

        Function<Double, Long> func2 = Math::round;
        System.out.println(func2.apply(12.6));
        System.out.println("*******************");

        Function<User, Integer> func4 = User::getAge;
        User user = new User();
        user.setAge(29);
        Integer apply = func4.apply(user);
        System.out.println("apply = " + apply);
    }

    @Test
    public void test5() {
        new Thread(() -> {
            System.out.println("你知道吗 我比你想象的 更想在你身边");
        }).start();
    }

    /**
     * 现有方法定义如下，其中IntBinaryOperator是一个接口。先使用匿名内部类的写法调用该方法
     */

    public static int calculateNum(IntBinaryOperator operator, int a, int b) {
        return operator.applyAsInt(a, b);
    }

    @Test
    public void test6() {
        int i = calculateNum(new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        }, 10, 20);
        System.out.println("i = " + i);
        int k = calculateNum((int left, int right) -> {
                    return left + right;
                }, 10, 20
        );
        System.out.println("k = " + k);
    }

    @Test
    public void test7() {
        printNumber(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        });
        printNumber((int value) -> value % 2 == 0);
    }

    @Test
    public void test8() {
        Integer o = typeConver(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        });
        System.out.println("o:" + o);

        Integer k = typeConver((String s) -> {
                    return Integer.valueOf(s);
                }
        );
        System.out.println("k = " + k);

    }

    @Test
    public void test10() {
        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) {
                return s.equals(s2);
            }
        } ;
        boolean test = biPredicate.test("abc", "abc");
        System.out.println("test = " + test);


        BiPredicate<String, String> biPredicate1 = (String o, String o2) -> o.equals(o2) ;
        boolean test1 = biPredicate1.test("abc", "abc");
        System.out.println("test1 = " + test1);



        BiPredicate<String, String> biPredicate2 = String::equals ;
        boolean test2 = biPredicate2.test("abc", "abc");
        System.out.println("test1 = " + test2);

    }


    public static void printNumber(IntPredicate intPredicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int k : arr) {
            if (intPredicate.test(k)) {
                System.out.println("k = " + k);
            }
        }
    }

    public static <R> R typeConver(Function<String, R> function) {
        String str = "123456";
        R result = function.apply(str);
        return result;
    }


}
