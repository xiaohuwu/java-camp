package com.ktb.dao;

import com.ktb.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DepartmentDao {
    List<Department> findAll();
    Department findById(String id);
    int  save(Department department);
    int  update(@Param("list")List<Department> list);
    int  deleteById(String id);
    List<Department>  findAllLazy();

}
