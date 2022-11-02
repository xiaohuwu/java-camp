package com.sangeng.controller;

import com.sangeng.entity.Article;
import com.sangeng.entity.Category;
import com.sangeng.entity.ResponseResult;
import com.sangeng.service.ArticleService;
import com.sangeng.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseResult<Category> list() {
        return categoryService.index();
    }
}
