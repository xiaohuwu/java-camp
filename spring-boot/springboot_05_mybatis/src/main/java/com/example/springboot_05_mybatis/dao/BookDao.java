package com.example.springboot_05_mybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_05_mybatis.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao extends BaseMapper<Book> {
//    @Select("select * from books where id = #{id}")
//    public Book getById(Integer id);
}
