package com.ktb.mybatis.dao;

import com.ktb.mybatis.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface DepartmentMapper {
    void save(Department department);
    List<Department> findAll();
}
