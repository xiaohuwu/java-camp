package com.atguigu.edu.controller;
import com.atguigu.edu.query.TeacherQuery;
import com.atguigu.edu.service.EduTeacherService;
import com.atguigu.edu.entity.EduTeacher;
import com.atguigu.servicebase.config.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2021-06-22
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduservice/eduTeacher")
@CrossOrigin
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

//    @ApiOperation(value = "所有讲师列表")
//    @GetMapping(value = "/list")
//    public R list() {
//        List<EduTeacher> list = teacherService.list(null);
//        return R.ok().data("items", list);
//    }


    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public R removeById(@PathVariable String id) {
        teacherService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("/save")
    public R save(@RequestBody EduTeacher eduTeacher) {
        eduTeacher.setGmtCreate(new Date());
        eduTeacher.setGmtModified(new Date());
        teacherService.save(eduTeacher);
        return R.ok();
    }

    @ApiOperation(value = "获取单个讲师详情")
    @GetMapping("/getOne/{teacher_id}")
    public R getOne(@PathVariable String teacher_id) {
        EduTeacher eduTeacher = teacherService.getById(teacher_id);
        return R.ok().data("item",eduTeacher);
    }

    @ApiOperation(value = "修改讲师")
    @PostMapping("/update")
    public R update(@RequestBody EduTeacher eduTeacher) {
        teacherService.updateById(eduTeacher);
        return R.ok();
    }

    @ApiOperation(value = "分页讲师列表")
    @PostMapping("/list/{page}/{limit}")
    public R pageQuery(@ApiParam(name = "page", value = "当前页码", required = true) @PathVariable Long page,
                       @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable Long limit,
                       @ApiParam(name = "teacherQuery", value = "查询对象", required = false) @RequestBody TeacherQuery teacherQuery) {
        Page pag = new Page(page, limit);
        teacherService.pageQuery(pag,teacherQuery);
        return R.ok().data("total", pag.getTotal()).data("records", pag.getRecords());
    }


}

