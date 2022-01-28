package com.example.springbootkuangsheng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springbootkuangsheng.model.TbUser;


public interface TbUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    int deleteById(@Param("id") Long id);

    List<TbUser> findAllByName(@Param("name") String name);

    List<TbUser> findAllById(@Param("id") Long id);


    int updateNameById(@Param("updatedName") String updatedName, @Param("id") Long id);

    List<TbUser> findAll();


}