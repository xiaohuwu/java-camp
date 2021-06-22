package com.ktb.guiguedu;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ktb.guiguedu.dao.UserMapper;
import com.ktb.guiguedu.model.User;
import org.apache.ibatis.session.RowBounds;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class GuiguEduApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------>>>>>>>>>>>>"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsertUser() {
        System.out.println(("----- selectAll method test ------>>>>>>>>>>>>"));
        User ge = new User("ge", 20, "120@qq.com");
        userMapper.insert(ge);
    }


    @Test
    public void testActiveInsertUser() {
        User user = new User("ge", 20, "120@qq.com");
        user.insert();
    }

    @Test
    public void testUpdateUser() {

//        boolean b = new User().setId(1L).setEmail("88").updateById();

        new User().update(new UpdateWrapper<User>().lambda().set(User::getAge,3).eq(User::getId,7));
    }

    @Test
    public void getUserOne() {

//        boolean b = new User().setId(1L).setEmail("88").updateById();
    }


    @Test
    public void page() {
        Page<User> page = new Page<>(1,5);
        Page<User> userPage = userMapper.selectPage(page, null);
        userPage.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }


    @Test
    public void testupdateUser() {
        System.out.println(("----- selectAll method test ------>>>>>>>>>>>>"));
        User user = userMapper.selectById(11);
        user.setName("Helen Yao");
        user.setEmail("helen@qq.com");
        userMapper.updateById(user);
    }

    /**
     * 测试 逻辑删除 */
    @Test
    public void testLogicDelete() {
        int result = userMapper.deleteById(11L);
        System.out.println(result);
    }

    @Test
    public void testLambda() {
        List<Integer> list = Arrays.asList(45,56,23,89,34,78,56);
        Map<Boolean, List<Integer>> collect = list.stream()
                .filter(i -> i * 2 > 60)
                .sorted()
                .map(i -> i - 10)
                .distinct()
                .collect(Collectors.groupingBy(i -> i >= 50, Collectors.toList()));
        System.out.println(collect);
    }

}
