package com.sangeng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.entity.Category;
import com.sangeng.mapper.CategoryMapper;
import com.sangeng.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 分类表(Category)表服务实现类
 *
 * @author 66
 * @since 2022-05-10 23:34:53
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}

