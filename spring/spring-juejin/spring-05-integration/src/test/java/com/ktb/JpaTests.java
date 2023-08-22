package com.ktb;

import com.ktb.dao.DepartmentDao;
import com.ktb.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:data/spring-data-jpa.xml")
public class JpaTests {
    @Autowired
    DepartmentDao departmentDao;



    @Test
    public void testSave() {
        Department department = new Department();
        department.setName("test department");
        department.setTel("1122334");
        departmentDao.save(department);
    }




    @Test
    public void testFindAll() {
        System.out.println("testFindAll ......");
        List<Department> departmentList = departmentDao.findAll();
        departmentList.forEach(System.out::println);
    }



}
