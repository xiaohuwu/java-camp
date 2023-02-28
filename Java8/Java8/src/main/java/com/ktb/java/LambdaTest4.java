package com.ktb.java;

import com.ktb.model.MyStudent;
import com.ktb.model.Student;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://juejin.cn/post/6844903849753329678 题目来源
 */
public class LambdaTest4 {

    public List<Student> students() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));
        return students;
    }

    /**
     * list to set
     */
    @Test
    public void test1() {
        Set<Student> collect = Stream.of(new Student("路飞", 22, 175),
                new Student("红发", 40, 180),
                new Student("白胡子", 50, 185)).collect(Collectors.toSet());
        System.out.println("collect.getClass() = " + collect.getClass());

    }

    /**
     * list to map
     */
    @Test
    public void test2() {
        Map<Integer, Student> collect = Stream.of(new Student("路飞", 22, 175),
                new Student("红发", 40, 180),
                new Student("白胡子", 50, 185)).collect(Collectors.toMap(Student::getAge, (student) -> {
            return student;
        }));
        collect.forEach((key, val) -> {
            System.out.println("key = " + key);
            System.out.println("val = " + val);
        });
        System.out.println("collect.getClass() = " + collect.getClass());
    }

    /**
     * list to string
     */
    @Test
    public void test3() {
        String collect = Stream.of(new Student("路飞", 22, 175),
                new Student("红发", 40, 180),
                new Student("白胡子", 50, 185)).map(Student::getName).collect(Collectors.joining(","));
        System.out.println("collect = " + collect);
    }

    /**
     * filter
     * 筛选出出身高小于180的同学。
     */
    @Test
    public void test4() {
        List<Student> students = students();
        List<Student> collect = students.stream().filter((item) -> {
            return item.getHeight() < 180;
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 对象原地转换
     */
    @Test
    public void test5() {
        List<Student> students = students();
        List<String> collect = students.stream().map((item) -> {
            return item.getName();
        }).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    /**
     * 将多个Stream合并为一个Stream。惰性求值
     * 调用Stream.of的静态方法将两个list转换为Stream，再通过flatMap将两个流合并为一个
     */
    @Test
    public void test6() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        List<Student> students2 = new ArrayList<>(2);
        students2.add(new Student("艾斯", 25, 183));
        students2.add(new Student("雷利", 48, 176));

//        将多个Stream合并为一个Stream
        Stream.of(students, students2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    /**
     * 年龄最大的同学
     */
    @Test
    public void test7() {
        List<Student> students = students();
        Optional<Student> max = students.stream().max(Comparator.comparingInt(Student::getAge));
        max.ifPresent(student -> System.out.println("student = " + student));

        /**
         * 下面这总感觉更加简洁
         */
        Student student = students.stream().max(Comparator.comparingInt(Student::getAge)).orElse(null);
        System.out.println("student = " + student);
    }

    /**
     * 年龄最小的同学
     */
    @Test
    public void test8() {
        List<Student> students = students();
        /**
         * 下面这总感觉更加简洁
         */
        Student student = students.stream().min(Comparator.comparingInt(Student::getAge)).orElse(null);
        System.out.println("student = " + student);
    }

    /**
     * 年龄小于40的总人数
     */
    @Test
    public void test9() {
        List<Student> students = students();
        /**
         * 下面这总感觉更加简洁
         */
        long count = students.stream().filter((item) -> {
            return item.getAge() < 40;
        }).count();
        System.out.println("count = " + count);
    }


    /**
     * 年龄小于40的总人数
     */
    @Test
    public void test10() {
        List<Student> students = students();
        Map<Boolean, List<Student>> collect = students.stream().collect(
                Collectors.partitioningBy(new Predicate<Student>() {
                    @Override
                    public boolean test(Student o) {
                        return o.getAge() == 20;
                    }
                }));
        System.out.println("collect = " + collect);
    }

    /**
     * 按年龄分组
     * list to array
     */
    @Test
    public void test11() {
        List<Student> students = students();
        Map<Integer, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getAge));
        Student[] as = students.stream().toArray(Student[]::new);
        System.out.println("collect = " + collect);
        System.out.println("as = " + Arrays.toString(as));
    }


    @Test
    public void test12() {
        Long max = 10000000L;
        List<MyStudent> values = new ArrayList<MyStudent>();
        for (int i = 0; i < max; i++) {
            Long random = Double.valueOf(Math.random() * max).longValue();
            values.add(new MyStudent(random));
        }
        long t0 = System.nanoTime();
        List<MyStudent> collect = values.stream().sorted().collect(Collectors.toList());
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("test12 sort took: %d ms", millis));
    }


    /**
     * test12 需要和test13 对比着看
     */
    @Test
    public void test13() {
        Long max = 20000000L;
        List<Long> values = new ArrayList<Long>();
        for (int i = 0; i < max; i++) {
            Long random = Double.valueOf(Math.random() * max).longValue();
            values.add(random);
        }
        long t0 = System.nanoTime();
        List<Long> collect = values.parallelStream().sorted().collect(Collectors.toList());
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("test13 sort took: %d ms", millis));
    }


}
