package com.sangeng.controller;

import com.sangeng.entity.Article;
import com.sangeng.entity.ResponseResult;
import com.sangeng.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    public List<Article> articleList(Integer pageNum,Integer pageSize,Integer categoryId) {
        return articleService.articleList(pageNum,pageSize,categoryId);
    }


    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {
        ResponseResult result = articleService.hotArticleList();
        return result;
    }


}
