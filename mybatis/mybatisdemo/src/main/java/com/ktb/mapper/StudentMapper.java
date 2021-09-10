package com.ktb.mapper;

import com.ktb.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper {
    // 查询学生
    List<Student> getStudent();
    Student getStudentByMap(HashMap map);

    Student getStudentByIdAndName(Integer id, @Param("name") String name);

    Student getStudentByNumber(@Param("number") Integer  number);
}

