package com.ktb.dao;

import com.ktb.entity.Department;
import com.ktb.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    Employee findOne(@Param("id") int id);

    public Integer insertEmployee(Employee employee);
}
