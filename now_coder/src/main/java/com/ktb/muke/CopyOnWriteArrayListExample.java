package com.ktb.muke;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        // 创建 CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // 添加元素
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // 使用迭代器遍历列表
        for (String language : list) {
            System.out.println(language);
            // 在迭代过程中尝试修改列表
            if ("Python".equals(language)) {
                list.add("JavaScript");
            }
        }

        // 再次遍历以显示最终列表
        System.out.println("After modification:");
        for (String language : list) {
            System.out.println(language);
        }
    }
}
