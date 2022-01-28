package com.example.springbootkuangsheng.dao;

import com.example.springbootkuangsheng.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CityMapper {

    @Select("SELECT * FROM tb_user  WHERE name = #{name}")
    List<User> findByState(@Param("name") String state);

}
