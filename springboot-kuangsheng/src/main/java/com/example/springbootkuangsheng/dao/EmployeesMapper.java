package com.example.springbootkuangsheng.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.springbootkuangsheng.model.Employees;

public interface EmployeesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employees record);

    int insertSelective(Employees record);

    Employees selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);


    List<Employees> getEmployees();


}