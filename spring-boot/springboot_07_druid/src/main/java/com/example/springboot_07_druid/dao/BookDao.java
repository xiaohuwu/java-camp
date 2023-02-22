package com.example.springboot_07_druid.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_07_druid.model.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
//    @Select("select * from books where id = #{id}")
//    public Book getById(Integer id);
}
