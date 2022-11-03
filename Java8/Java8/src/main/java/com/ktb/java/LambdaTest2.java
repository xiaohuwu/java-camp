package com.ktb.java;

import com.ktb.model.UserInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LambdaTest2 {
    /**
     * list to map  Collectors.toMap
     */
    @Test
    public void test1() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27));
        userInfoList.add(new UserInfo(2L, "捡瓶子的小男孩", 26));

        Map<Long, UserInfo> collect = userInfoList.stream().collect(Collectors.toMap(UserInfo::getId, userInfo -> userInfo, (k1, k2) -> k1));
        collect.forEach((k, v) -> System.out.println("k:" + k + "v:" + v));
    }

    @Test
    public void test2() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27));
        userInfoList.add(new UserInfo(3L, "捡瓶子的小男孩", 26));
        /**
         * filter 过滤，留下超过18岁的用户
         */
        List<UserInfo> collect = userInfoList.stream().filter((item) -> item.getAge() > 18).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 原地转换
     */
    @Test
    public void test3() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27));
        userInfoList.add(new UserInfo(3L, "捡瓶子的小男孩", 26));
        List<String> collect = userInfoList.stream().map((item) -> item.getName()).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


    @Test
    public void test4() {
        List<UserInfo> userInfoList = new ArrayList<>();
//        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18));
//        userInfoList.add(new UserInfo(2L, "程序员田螺", 27));
//        userInfoList.add(new UserInfo(3L, "捡瓶子的小男孩", 26));
        UserInfo userInfo = userInfoList.stream().findFirst().orElse(null);
        System.out.println("userInfo = " + userInfo);
    }


    /**
     * groupingBy
     */
    @Test
    public void test5() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27));
        userInfoList.add(new UserInfo(3L, "捡瓶子的小男孩", 18));
        Map<Integer, List<UserInfo>> collect = userInfoList.stream().collect(Collectors.groupingBy(UserInfo::getAge));
        collect.forEach((key, val) -> {
            System.out.print("key = " + key + "\t");
            System.out.println("val = " + val);
        });
    }

    /**
     * 去重 如果比较对象需要重写 equals 和 hashCode 方法
     */
    @Test
    public void test6() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27));
        userInfoList.add(new UserInfo(2L, "捡瓶子的小男孩", 26));
        List<UserInfo> collect = userInfoList.stream().distinct().collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 排序
     */
    @Test
    public void test7() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27));
        userInfoList.add(new UserInfo(2L, "捡瓶子的小男孩", 26));
        userInfoList.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).forEach(System.out::println);
    }


    /**
     * limit 截取
     * 取年龄最小的用户
     */
    @Test
    public void test8() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27));
        userInfoList.add(new UserInfo(2L, "捡瓶子的小男孩", 26));
        List<UserInfo> collect = userInfoList.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).limit(1).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序
     */
    @Test
    public void test9() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27));
        userInfoList.add(new UserInfo(2L, "捡瓶子的小男孩", 26));
        List<UserInfo> collect = userInfoList
                .stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .skip(1)
                .peek((item) -> {
                    System.out.println("item = " + item); //peek 扭转过程中的中间操作
                })
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


}
