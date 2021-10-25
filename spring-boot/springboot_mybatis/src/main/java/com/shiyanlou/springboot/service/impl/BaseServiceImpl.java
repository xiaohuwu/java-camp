package com.shiyanlou.springboot.service.impl;

import com.shiyanlou.springboot.dao.BaseMapper;
import com.shiyanlou.springboot.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public  class BaseServiceImpl<T>  implements IBaseService<T> {

    @Autowired
    protected BaseMapper<T> baseMapper;

    @Override
    public Integer save(T t) {
        return baseMapper.save(t);
    }

    @Override
    public void delete(Integer id) {
        baseMapper.delete(id);
    }

    @Override
    public T findById(Integer id) {
        return baseMapper.findById(id);
    }

    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    public List<T> list() {
        return baseMapper.list();
    }

}
