package com.ktb.mybatis.dao;

import com.ktb.mybatis.entity.Department;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    public void save(Department department) {
        sqlSessionTemplate.insert("dept.save", department);
    }

    public List<Department> findAll() {
        return sqlSessionTemplate.selectList("dept.findAll");
    }
}
