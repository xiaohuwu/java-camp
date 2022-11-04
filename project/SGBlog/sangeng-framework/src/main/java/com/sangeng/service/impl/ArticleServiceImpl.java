package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.entity.*;
import com.sangeng.mapper.ArticleMapper;
import com.sangeng.mapper.CategoryMapper;
import com.sangeng.service.ArticleService;
import com.sangeng.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 文章表(Article)表服务实现类
 *
 * @author 66
 * @since 2022-05-10 23:17:01
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<Article>();
        queryWrapper.eq(Article::getStatus, 0);
        queryWrapper.orderByDesc(Article::getViewCount);
        queryWrapper.last("limit 0,10");
        List<Article> articleList = articleMapper.selectList(queryWrapper);
        List<HotArticleVo> collect = articleList.stream().map((item) -> {
            HotArticleVo hotArticleVo = BeanCopyUtils.copyBean(item, HotArticleVo.class);
            return hotArticleVo;
        }).collect(Collectors.toList());
        return ResponseResult.okResult(collect);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Integer categoryId) {
        int start = pageSize * (pageNum - 1);
        List<Article> articles = articleMapper.articleList(start, pageSize, categoryId);
        System.out.println("articles = " + "over");
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<Article>();
        queryWrapper.eq(Article::getStatus, 0);
        queryWrapper.eq(!Objects.isNull(categoryId), Article::getCategoryId, categoryId);
        Integer count = articleMapper.selectCount(queryWrapper);
        Page<Article> page = new Page<Article>(pageNum,pageSize);
        IPage<Article> page1 = articleMapper.selectPage(page, queryWrapper);

        List<Long> collect1 = page1.getRecords().stream().map(Article::getCategoryId).collect(Collectors.toList());
        List<Category> categories = categoryMapper.selectBatchIds(collect1);
        Map<Long, String> collect2 = categories.stream().collect(Collectors.toMap(Category::getId, Category::getName, (k1, k2) -> k1));

        List<ArticleVo> collect = page1.getRecords().stream().map((item) -> {
            ArticleVo articleVo = BeanCopyUtils.copyBean(item, ArticleVo.class);
            articleVo.setCategoryName(collect2.get(item.getCategoryId()));
            return articleVo;
        }).collect(Collectors.toList());

        PageVo pageVo = new PageVo();
        pageVo.setRows(collect);
        pageVo.setTotal(count);
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult findById(Integer id) {
        Article article = articleMapper.selectById(id);
        Category category = categoryMapper.selectById(article.getCategoryId());
        article.setCategory_name(category.getName());
        return ResponseResult.okResult(article);
    }


}

