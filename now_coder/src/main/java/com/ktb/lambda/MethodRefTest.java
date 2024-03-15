package com.ktb.lambda;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 方法引用 -->lambda表达式的简写
 * <p>
 * 方法引用的使用
 * 1.使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 * 方法引用，也是函数式接口的实例。
 * 3. 使用格式：  类(或对象) :: 方法名
 * 4. 具体分为如下的三种情况：
 * 情况1     对象 :: 非静态方法
 * 情况2     类 :: 静态方法
 * <p>
 * 情况3     类 :: 非静态方法
 * <p>
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 * 形参列表和返回值类型相同！（针对于情况1和情况2）
 * <p>
 * Created by shkstart.
 */
public class MethodRefTest {
    /**
     * void accept(T t);
     * void println(String x)
     */
    @Test
    public void test1() {
        Consumer<String> con1 = str -> {
            System.out.println(str);
        };
        con1.accept("good");
        System.out.println("*****************************");
        PrintStream out = System.out;
        Consumer<String> con2 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        };
        con2.accept("好");
    }

    @Test
    public void test2() {
        Function<Integer, String[]> func1 = length -> {
            return new String[length];
        };
        String[] apply = func1.apply(4);
        System.out.println(Arrays.toString(apply));
        System.out.println("*****************************");
        Function<Integer, String[]> function = String[]::new;
        String[] apply1 = function.apply(6);
        System.out.println(Arrays.toString(apply1));
    }

    @Test
    public void test3() {
        List.of("  Apple ", " pear ", " ORANGE", " BaNaNa ")
                .stream().map(String::trim).map(String::toUpperCase).forEach(System.out::println);


        Function<Long, Long> f = Math::abs;
        Long result = f.apply(-3L);


        BiPredicate<String, String> b = String::equals;
        boolean test = b.test("abc", "abcd");
        System.out.println("test = " + test);

        IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter((item) -> item % 2 == 1).forEach(System.out::println);

        Integer reduce = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (BinaryOperator) (o, o2) -> (int) o + (int) o2);
        System.out.println("reduce = " + reduce);

        int[] numbers = {1, 2, 3, 4, 5}; // 示例数组

        int sum = Arrays.stream(numbers).sum(); // 使用Streams API求和

        System.out.println("Sum: " + sum); // 打印总和

        Person[] people = {
                new Person(25),
                new Person(30),
                new Person(35)
        };

        int sum1 = Arrays.stream(people).mapToInt(Person::getAge).sum();
        System.out.println("sum1 = " + sum1);


        Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> collect = stream.collect(Collectors.toList());
        collect.forEach(System.out::println);

        List<String> list = List.of("Apple", "Banana", "Orange");
        String[] array = list.stream().toArray(String[]::new);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));


        stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> collect1 = stream.collect(Collectors.toMap(s -> s.split(":")[0], s -> s.split(":")[1]));
        collect1.forEach((key, val) -> {
            System.out.println("key = " + key);
            System.out.println("val = " + val);
        });


         list = List.of("Apple", "Banana", "Blackberry", "Coconut", "Avocado", "Cherry", "Apricots");
        Map<String, List<String>> collect2 = list.stream().collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toList()));
        System.out.println("collect2 = " + collect2);


        Stream<String> s1 = List.of("A", "B", "C").stream();
        Stream<String> s2 = List.of("D", "E").stream();
        Stream<String> concat = Stream.concat(s1, s2);
        System.out.println("concat = " + concat.collect(Collectors.toList()));

    }




    @Test
    public void test4() {

    }


    class Person {
        private int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

}
