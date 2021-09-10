package com.ktb.springbootredis;

import com.ktb.springbootredis.model.School;
import com.ktb.springbootredis.model.Teacher;
import com.ktb.springbootredis.repository.SchoolRepository;
import com.ktb.springbootredis.repository.TeacherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OneToManyTest {

    @Resource
    SchoolRepository schoolRepository;

    @Resource
    TeacherRepository teacherRepository;

    @Test
    public void add() {
        School school1 = new School();
        school1.setName("清华大学");
        schoolRepository.save(school1);
        Teacher teacher = new Teacher();
        teacher.setName("long");
        teacher.setSchool(school1);
        teacherRepository.save(teacher);
    }

    @Test
    public void find() {
        School school1 = new School();
        school1 = schoolRepository.findById(2);
        List<Teacher> teacherList = school1.getTeacherList();
        System.out.println(school1.getName());
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.getName());
        }
    }

    @Test
    public void deleteSchoolById() {
        schoolRepository.deleteById(3);
    }

    @Test
    public void deleteTeacherById() {
        teacherRepository.deleteById(7);
    }



}
