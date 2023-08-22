package com.ktb;


import com.ktb.config.MyBatisConfiguration;
import com.ktb.mybatis.dao.DepartmentMapper;
import com.ktb.mybatis.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MyBatisConfiguration.class})
public class MyBatisAnnoTests {

    @Autowired
    DepartmentMapper departmentMapper;



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
