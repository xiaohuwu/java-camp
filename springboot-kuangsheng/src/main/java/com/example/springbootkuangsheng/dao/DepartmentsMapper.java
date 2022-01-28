package com.example.springbootkuangsheng.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.springbootkuangsheng.model.Departments;


public interface DepartmentsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Departments record);

    int insertSelective(Departments record);



    int updateByPrimaryKeySelective(Departments record);

    int updateByPrimaryKey(Departments record);


    List<Departments> findall();

    Departments selectByPrimaryKey(Long id);


}