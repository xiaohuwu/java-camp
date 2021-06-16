package com.ktb.springbootmybatis.controller;

import com.ktb.springbootmybatis.entity.Student;
import com.ktb.springbootmybatis.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2021-06-16 21:16:34
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Student selectOne(Integer id) {
        return this.studentService.queryById(id);
    }

    @PostMapping("/insertOne")
    public Student insert(Student student) {
        return this.studentService.insert(student);
    }


    @PostMapping("/updateOne")
    public Student updateOne(Student student) {
        return this.studentService.update(student);
    }

    @DeleteMapping("/deleteOne")
    public boolean deleteOne(Integer id) {
        return this.studentService.deleteById(id);
    }

}
