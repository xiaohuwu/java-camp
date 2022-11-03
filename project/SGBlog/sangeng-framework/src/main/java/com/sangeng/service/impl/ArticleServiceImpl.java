package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.entity.Article;
import com.sangeng.entity.HotArticleVo;
import com.sangeng.entity.ResponseResult;
import com.sangeng.mapper.ArticleMapper;
import com.sangeng.service.ArticleService;
import com.sangeng.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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
    public List<Article> articleList(Integer pageNum, Integer pageSize, Integer categoryId) {
        return null;
    }


}

