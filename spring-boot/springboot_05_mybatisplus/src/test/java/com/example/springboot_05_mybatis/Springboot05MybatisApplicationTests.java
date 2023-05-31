package com.example.springboot_05_mybatis;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_05_mybatis.entity.Orders;
import com.example.springboot_05_mybatis.entity.User;
import com.example.springboot_05_mybatis.mapper.UserMapper;
import com.example.springboot_05_mybatis.service.OrderService;
import com.example.springboot_05_mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    void add() {
        User user = new User();
        user.setAge(20);
        user.setName("xiaohuge");
        user.setUserName("小虎哥");
        user.setAddress("cd");
        user.setPassword("123456");
        int insert = userMapper.insert(user);
    }

    @Test
    public void delete() {
//        int i = userMapper.deleteById(6);
        userMapper.deleteBatchIds(Arrays.asList(5));
    }


    @Test
    public void testUpdate() {
        LambdaUpdateWrapper<User> userWrapper = new UpdateWrapper<User>().lambda();
        userWrapper.eq(User::getId, 5)
                .set(User::getUserName, "小虎哥哥")
                .set(User::getAge, 30);
        userMapper.update(null, userWrapper);
    }

    /**
     * SELECT
     * id,user_name,PASSWORD,NAME,age,address
     * FROM
     * USER
     * WHERE
     * age > 18 AND address = '狐山'
     */
    @Test
    public void testQuery1() {
        LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<>();
        userWrapper.gt(User::getAge, 18)
                .eq(User::getAddress, "狐山");
        List<User> users = userMapper.selectList(userWrapper);
        users.forEach(System.out::println);
    }

    /**
     * SELECT
     * id,user_name,PASSWORD,NAME,age,address
     * FROM
     * USER
     * WHERE
     * id IN(1,2,3) AND
     * age BETWEEN 12 AND 29 AND
     * address LIKE '%山%'
     */
    @Test
    public void testQuery2() {
        LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<>();
        List<Integer> ids = Arrays.asList(1, 2, 3);
        userWrapper.in(User::getId, ids)
                .between(User::getAge, 12, 29)
                .like(User::getAddress, "山");
        List<User> users = userMapper.selectList(userWrapper);
        users.forEach(System.out::println);
    }

    /**
     * SELECT
     * id,user_name,PASSWORD,NAME,age,address
     * FROM
     * USER
     * WHERE
     * id IN(1,2,3) AND
     * age > 10
     * ORDER BY
     * age DESC
     */

    @Test
    public void testQuery3() {
        LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<>();
        List<Integer> ids = Arrays.asList(1, 2, 3);
        userWrapper.in(User::getId, ids)
                .gt(User::getAge, 10)
                .orderByDesc(User::getAge);
        List<User> users = userMapper.selectList(userWrapper);
        users.forEach(System.out::println);
    }


    @Test
    public void testQuery4() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<Integer> ids = Arrays.asList(1);
        lambdaQueryWrapper.in(User::getId, ids);
        User myUserByWrapper = userMapper.findMyUserByWrapper(lambdaQueryWrapper);
        System.out.println("myUserByWrapper = " + myUserByWrapper);
    }


    @Test
    public void testPage() {
        IPage<User> page = new Page<>();
        userMapper.selectPage(page, null);
        System.out.println(page.getRecords());//获取当前页的数据
        System.out.println(page.getTotal());//获取总记录数
        System.out.println(page.getCurrent());//当前页码
    }

    @Test
    public void testQuery5() {
        System.out.println("\"------------\" = " + "------------");
        Page<User> page = new Page<>();
        IPage<Orders> allOrders = orderService.findAllOrders(page);
        System.out.println(allOrders.getRecords());//获取当前页的数据
        System.out.println(allOrders.getTotal());//获取总记录数
        System.out.println(allOrders.getCurrent());//当前页码
    }

    @Test
    public void testQuery6() {
        System.out.println("\"------------\" = " + "------------");
        User test = userService.test();
        System.out.println("test = " + test);
    }


    @Test
    public void testUpdate01() {
        System.out.println("\"------------\" = " + "------------");
        Orders orders = new Orders();
        orders.setId(1L);
        orders.setPrice(120);
        orderService.updateById(orders);
    }

    @Test
    public void testQuery7() {
        System.out.println("\"------------\" = " + "------------");
        orderService.removeById(1);
        List<Orders> list = orderService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void testQuery08() {
        System.out.println("\"------------\" = " + "------------");
        Orders byId = orderService.getById(2);
        byId.setPrice(230);
        orderService.updateById(byId);
    }

}
