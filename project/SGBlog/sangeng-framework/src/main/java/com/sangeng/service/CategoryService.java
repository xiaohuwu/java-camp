package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.entity.Category;
import com.sangeng.entity.ResponseResult;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-11-02 22:55:25
 */
public interface CategoryService extends IService<Category> {

    ResponseResult<Category> index();
}
