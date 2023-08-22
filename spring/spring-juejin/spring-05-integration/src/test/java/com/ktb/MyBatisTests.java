package com.ktb;


import com.ktb.config.MyBatisConfiguration;
import com.ktb.mybatis.dao.DepartmentDao;
import com.ktb.mybatis.dao.DepartmentMapper;
import com.ktb.mybatis.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


public class MyBatisTests {



    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void testDaoSave() {
        Department department = new Department();
        department.setName("mybatis dao name");
        department.setTel("mybatis dao tel");
        departmentDao.save(department);
    }

    @Test
    public void testDaoFindAll() {
        System.out.println(departmentDao.findAll());
    }


    @Test
    public void testMapperSave() {
        Department department = new Department();
        department.setName("mybatis mapper name");
        department.setTel("mybatis mapper tel");
        departmentMapper.save(department);
    }

    @Test
    public void testMapperFindAll() {
        System.out.println(departmentMapper.findAll());
    }


}
