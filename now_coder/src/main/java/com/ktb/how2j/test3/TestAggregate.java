package com.ktb.how2j.test3;

import com.ktb.how2j.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestAggregate {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Hero> arrayList = new ArrayList<Hero>();
        for (int i = 0; i < 10; i++) {
            Hero hero = new Hero("hero" + i, random.nextInt(200), random.nextInt(100));
            arrayList.add(hero);
        }
        System.out.println("初始化后的集合：");
        System.out.println(arrayList);
        System.out.println("查询条件：hp>100 && damage<50");
        System.out.println("通过传统操作方式找出满足条件的数据：");

        for (Hero h : arrayList) {
            if (h.hp > 100 && h.damage < 50)
                System.out.println(h.name);
        }

        List<Hero> collect = arrayList.stream().filter((Hero hero) -> {
            return hero.hp > 100 && hero.damage < 50;
        }).collect(Collectors.toList());
        for (Hero hero : collect) {
            System.out.println("hero" + hero.toString());
        }
    }
}
