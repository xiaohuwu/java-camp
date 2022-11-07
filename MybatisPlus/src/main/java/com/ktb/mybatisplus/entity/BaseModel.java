package com.ktb.mybatisplus.entity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseModel {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    private QueryWrapper one_get_many(List<BaseModel> records,String foreign_key) {
        Set<Integer> foreign_key_ids = records.stream().map(BaseModel::getId).collect(Collectors.toSet());
        QueryWrapper in = Wrappers.query().in(foreign_key, foreign_key_ids);
        return in;
    }

}
