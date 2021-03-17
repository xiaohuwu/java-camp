package com.ktb;

import com.ktb.mapper.StudentMapper;
import com.ktb.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从 SqlSessionFactory 中获取 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student tom = mapper.getStudentByIdAndName(1, "tom");
        System.out.println(tom);
        // 使用 SqlSession 查询
        HashMap map = new HashMap<>();
        map.put("id",1);
        map.put("lastName","知识追寻者");
        //Student getStudent = mapper.getStudentByMap(map);
        //System.out.println("getStudent:" + getStudent);
        // 关闭 SqlSession
        sqlSession.close();

    }
}
