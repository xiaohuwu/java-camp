package com.ktb.mybatisplus.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ktb.mybatisplus.entity.BaseModel;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * private void one_get_many(List<Dept> records) {
 * Set<Integer> dept_ids = records.stream().map(Dept::getId).collect(Collectors.toSet());
 * LambdaQueryWrapper<Student> studentWrapper = Wrappers.lambdaQuery(Student.class).in(Student::getDeptId, dept_ids);
 * Map<Integer, List<Student>> students = studentMapper.selectList(studentWrapper).stream().collect(Collectors.groupingBy(Student::getDeptId));
 * records.forEach((item) -> {
 * item.setStudents(students.get(item.getId()));
 * });
 * }
 */
public class QueryUtils {

    public static QueryWrapper one_get_many(List<? extends BaseModel> records, String foreign_key) {
        Set<Integer> foreign_key_ids = records.stream().map(BaseModel::getId).collect(Collectors.toSet());
        QueryWrapper<BaseModel> wrapper = Wrappers.query();
        QueryWrapper<BaseModel> in = wrapper.in(foreign_key, foreign_key_ids);
        return in;
    }

}
