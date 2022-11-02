package com.sangeng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sangeng.entity.Article;
import com.sangeng.entity.ResponseResult;

import java.util.List;

/**
 * 文章表(Article)表服务接口
 *
 * @author 66
 * @since 2022-05-10 23:17:01
 */
public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    List<Article> articleList(Integer pageNum, Integer pageSize, Integer categoryId);

}

