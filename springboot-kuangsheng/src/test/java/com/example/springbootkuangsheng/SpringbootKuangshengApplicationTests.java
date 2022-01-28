package com.example.springbootkuangsheng;

import com.example.springbootkuangsheng.dao.DepartmentsMapper;
import com.example.springbootkuangsheng.dao.EmployeesMapper;
import com.example.springbootkuangsheng.model.Departments;
import com.example.springbootkuangsheng.model.Dog;
import com.example.springbootkuangsheng.model.Person;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = SpringbootKuangshengApplication.class)
class SpringbootKuangshengApplicationTests {

    @Autowired
    Dog dog;

    @Autowired
    Person person;


    @Autowired
    DepartmentsMapper departmentMapper;

    @Autowired
    EmployeesMapper employeeMapper;

    @Test
    void contextLoads() {
        System.out.println("dog = " + dog);
        System.out.println("person = " + person);
        person.getLists().stream().filter((item) -> item.equals("good")).collect(Collectors.toList());
        try {

        } catch (Exception e) {
            e.getCause().printStackTrace();
        }
    }


    /**
     * guava 里面 一些比较实用的工具类
     */
    @Test
    void test_02() {
        List<Integer> listOne = Ints.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> listTwo = Ints.asList(6, 7);
        Set<Integer> difference = Sets.difference(Sets.newHashSet(listOne), Sets.newHashSet(listTwo));
        System.out.println("difference = " + difference);
    }


    @Test
    void test_03() {
        System.out.println("throws SQLException----");
        departmentMapper.findall().forEach((item) -> {
            System.out.println("getDepartmentname:" + item.getDepartmentName());
        });
    }

    @Test
    void test_04() {
        employeeMapper.getEmployees().forEach((item) -> {
            System.out.println("item = " + item);
        });
    }


    @Test
    void get_one() {
        Departments departments = departmentMapper.selectByPrimaryKey(1L);
        System.out.println("departments = " + departments);
    }


}
