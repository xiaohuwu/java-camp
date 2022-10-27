package com.ktb.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktb.mybatisplus.mapper.OrderMapper;
import com.ktb.mybatisplus.mapper.UserMapper;
import com.ktb.mybatisplus.entity.Orders;
import com.ktb.mybatisplus.entity.User;
import com.ktb.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper orderMapper;


    @Test
    void list() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsertUser() {
//        User user = new User();
//        user.setName("张三").setAge(18).setEmail("123@qq.com").setSex(SexEnum.FEMALE);
//        userMapper.insert(user);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> select = queryWrapper.select("max(uid) as uid");
        User user1 = userMapper.selectOne(select);
        User user2 = userMapper.selectById(user1.getUid());
        System.out.println(user2);
    }

    @Test
    public void testDeleteUser() {
        int i = userMapper.deleteById(16);
        System.out.println("i = " + i);
        userMapper.selectList(null).forEach(System.out::println);
    }


    @Test
    public void testWrapper01() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.ge("age", 18);
        wrapper.eq("email", "123@qq.com");
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testUpdateById() {
        User user = new User();
        user.setName("张三").setEmail("123@qq.com").setUid(6L);
        int i = userMapper.updateById(user);
        userMapper.selectById(user.getUid());
    }


    @Test
    public void testSelectBatchIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
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
    public void testWrapper02() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("id", Arrays.asList(1, 2, 3, 1485992030160064518L));
        wrapper.between("age", 12, 29);
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }


    @Test
    public void testWrapper03() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("id", Arrays.asList(1, 2, 3, 1485992030160064518L));
        wrapper.between("age", 12, 29);
        wrapper.like("address", "成");
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
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
    public void testWrapper04() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("id", 1, 2, 1485992030160064518L);
        wrapper.gt("age", 10);
        wrapper.orderByDesc("age");
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testWrapper05() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.select("name", "age");
        wrapper.in("id", 1, 2, 1485992030160064518L);
        wrapper.gt("age", 10);
        wrapper.orderByDesc("age");
        List list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    /**
     * SELECT
     * id,user_name,PASSWORD,NAME,age,address
     * FROM
     * USER
     * WHERE
     * age > 18 AND address = '狐山'
     * <p>
     * <p>
     * 若Lambda表达式的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，就可以使用这种方法：
     * BiPredicate<String, String> b = String::equals;
     * b.test("abc", "abcd");
     * String是一个类而equals为该类的定义的实例方法。BiPredicate中的唯一抽象方法test方法参数列表与equals方法的参数列表相同，都是接收两个String类型参数。
     */

    @Test
    public void testLambdaWrapper() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.select(User::getUid, User::getName);
        wrapper.in(User::getUid, 1, 2, 1485992030160064518L);
        wrapper.gt(User::getAge, 12);
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }


    @Test
    public void test09() {
        User myUserByWrapper = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUid, 1));
        System.out.println("myUserByWrapper = " + myUserByWrapper);
    }

    @Test
    public void testPage() {
        IPage<User> page = new Page<User>();
        page.setSize(2);
        page.setCurrent(2);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        System.out.println("userIPage.getTotal() = " + userIPage.getTotal());
        userIPage.getRecords().forEach(System.out::println);
    }


    /**
     * SELECT
     * o.*,u.`user_name`
     * FROM
     * USER u,orders o
     * WHERE
     * o.`user_id` = u.`id`
     */

    @Test
    public void testPageDetail() {
        IPage<User> page = new Page<User>();
        page.setSize(3);
        page.setCurrent(1);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        List<User> records = userIPage.getRecords();
        List<Long> collect = records.stream().map(User::getUid).collect(Collectors.toList());
        LambdaQueryWrapper<Orders> wrapper2 = new LambdaQueryWrapper();
        wrapper2.in(Orders::getUserId, collect);
        List<Orders> orders = orderMapper.selectList(wrapper2);
        for (User record : records) {

            System.out.println("record = " + record);

        }
    }

    @Autowired
    private UserService userService;

    @Test
    public void testService() {
        int count = userService.count();
        System.out.println("count = " + count);
    }


    @Test
    public void testService1() {
        ArrayList arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("张三" + i);
            user.setAge(18 + i);
            arrayList.add(user);
        }
        boolean b = userService.saveBatch(arrayList);
        System.out.println("b = " + b);
    }

}
