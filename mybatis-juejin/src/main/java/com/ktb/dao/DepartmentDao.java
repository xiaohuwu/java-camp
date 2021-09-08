package com.ktb.dao;

import com.ktb.entity.Department;

import java.util.List;


public interface DepartmentDao {
    List<Department> findAll();
    Department findById(String id);
    int  save(Department department);
    int  update(Department department);
    int  deleteById(String id);

}
