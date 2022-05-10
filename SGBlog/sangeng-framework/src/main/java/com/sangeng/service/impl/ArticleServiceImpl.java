package com.sangeng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sangeng.entity.Article;
import com.sangeng.entity.HotArticleVo;
import com.sangeng.entity.ResponseResult;
import com.sangeng.entity.SystemConstants;
import com.sangeng.enums.AppHttpCodeEnum;
import com.sangeng.mapper.ArticleMapper;
import com.sangeng.service.ArticleService;
import com.sangeng.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
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
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper
                .eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL)
                .orderByDesc(Article::getViewCount)
                .last("limit 10");
        List<Article> articles = articleMapper.selectList(lambdaQueryWrapper);
        List<HotArticleVo> collect = articles.stream().map(article -> {
            HotArticleVo hotArticleVo = BeanCopyUtils.copyBean(article, HotArticleVo.class);
            return hotArticleVo;
        }).collect(Collectors.toList());
        return new ResponseResult(AppHttpCodeEnum.SUCCESS.getCode(), collect);
    }
}

