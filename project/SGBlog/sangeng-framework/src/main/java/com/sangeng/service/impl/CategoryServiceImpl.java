package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.entity.Article;
import com.sangeng.entity.Category;
import com.sangeng.entity.CategoryVo;
import com.sangeng.entity.ResponseResult;
import com.sangeng.mapper.ArticleMapper;
import com.sangeng.mapper.CategoryMapper;
import com.sangeng.service.CategoryService;
import com.sangeng.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-11-02 22:55:25
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    /**
     * ①要求只展示有发布正式文章的分类
     * ②必须是正常状态的分类
     *
     * @return
     */
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ResponseResult<Category> index() {
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<Article>();
        lambdaQueryWrapper.eq(Article::getStatus, 0);
        List<Article> articles = articleMapper.selectList(lambdaQueryWrapper);
        List<Long> collect = articles.stream().map((item) -> item.getCategoryId()).collect(Collectors.toList());

        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<Category>();
        wrapper.eq(Category::getStatus, 0);
        wrapper.in(Category::getId, collect);
        List<Category> categories = categoryMapper.selectList(wrapper);

        List<CategoryVo> collect1 = categories.stream().map((item) -> {
            CategoryVo categoryVo = BeanCopyUtils.copyBean(item, CategoryVo.class);
            return categoryVo;
        }).collect(Collectors.toList());
        return ResponseResult.okResult(collect1);
    }
}
