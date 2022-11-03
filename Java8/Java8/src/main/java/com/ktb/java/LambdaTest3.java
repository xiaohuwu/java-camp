package com.ktb.java;

import com.ktb.model.Author;
import com.ktb.model.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest3 {

    public List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }

    /**
     * 打印所有书籍的名字。要求对重复的元素进行去重。
     */
    @Test
    public void test1() {
        List<Author> authors = getAuthors();
        authors.stream().flatMap((item) -> item.getBooks().stream()).distinct().forEach(System.out::println);
    }

    /**
     * 打印现有数据的所有分类。要求对分类进行去重
     */
    @Test
    public void test2() {
        List<Author> authors = getAuthors();
        authors.stream().flatMap((item) -> item.getBooks().stream()).peek((item) -> {
//            System.out.println(item);
        }).flatMap((item) -> {
            return Arrays.stream(item.getCategory().split(","));
        }).distinct().forEach(System.out::println);
    }

    /**
     * 分别获取这些作家的所出书籍的最高分和最低分并打印
     */
    @Test
    public void test3() {
        List<Author> authors = getAuthors();
        Integer max = authors.stream().flatMap((item) -> item.getBooks().stream()).map((item) -> item.getScore()).max((score1, score2) -> {
            return score1 - score2;
        }).get();
        System.out.println("max = " + max);


        Integer min = authors.stream().flatMap((item) -> item.getBooks().stream()).map((item) -> item.getScore()).min((score1, score2) -> {
            return score1 - score2;
        }).get();
        System.out.println("min = " + min);
    }

}
