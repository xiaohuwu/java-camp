package com.ktb.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ktb.mybatisplus.dao.ProductMapper;
import com.ktb.mybatisplus.dao.UserMapper;
import com.ktb.mybatisplus.model.Product;
import com.ktb.mybatisplus.model.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class ApplicationTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProductMapper productMapper;

    @Test
    public void test09() {
        String username = "J";
        Integer age = 18;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(User::getUid, User::getName, User::getAge, User::getEmail, User::getSex).like(StringUtils.isNotBlank(username), User::getName, username).eq(Objects.nonNull(age), User::getAge, 18);
        List<User> user = userMapper.selectList(queryWrapper);
        user.forEach(System.out::println);
    }


    //将(年龄大于20并且用户名中包含有a)或邮箱为null的用户信息修改
////UPDATE t_user SET age=?, email=? WHERE (username LIKE ? AND age > ? OR
//    email IS NULL)

    @Test
    public void test07() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("uid", "name", "age", "email")
                .like("name", "a")
                .gt("age", 20)
                .or().isNull("email");
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    //将用户名中包含有a并且(年龄大于20或邮箱为null)的用户信息修改
//UPDATE t_user SET age=?, email=? WHERE (username LIKE ? AND (age > ? OR
//    email IS NULL))
    @Test
    public void test08() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("uid", "name", "age", "email")
                .like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }


    @Test
    public void testConcurrentUpdate() {
        //1、小李
        Product p1 = productMapper.selectById(1L);
        System.out.println("小李取出的价格:" + p1.getPrice());

        //2、小王
        Product p2 = productMapper.selectById(1L);
        System.out.println("小王取出的价格:" + p2.getPrice());


        //3、小李将价格加了50元，存入了数据库
        p1.setPrice(p1.getPrice() + 50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改结果:" + result1);

         //4、小王将商品减了30元，存入了数据库
        p2.setPrice(p2.getPrice() - 30);
        int result2 = productMapper.updateById(p2);
        System.out.println("小王修改结果:" + result2);
        if (result2 == 0) {
            System.out.println("小王修改失败，需要重新修改");
            p2 = productMapper.selectById(1L);
            p2.setPrice(p2.getPrice() - 30);
            int i = productMapper.updateById(p2);
            System.out.println("小王修改结果:" + i);
        }
        //最后的结果
        Product p3 = productMapper.selectById(1L); //价格覆盖，最后的结果:70
        System.out.println("最后的结果:" + p3.getPrice());

    }




}
