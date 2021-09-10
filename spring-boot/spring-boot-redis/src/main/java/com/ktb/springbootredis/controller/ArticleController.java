package com.ktb.springbootredis.controller;


import com.ktb.springbootredis.model.Article;
import com.ktb.springbootredis.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("article")
public class ArticleController {

    @Resource
    ArticleRepository articleRepository;

    @GetMapping("/add")
    public String addArticle() throws Exception {
        return "article/add";
    }

    @GetMapping("/index")
    public String index(@RequestParam(value = "start", defaultValue = "0") Integer start,
                        @RequestParam(value = "limit", defaultValue = "5") Integer limit, Model mav) throws Exception {
        start = start < 0 ? 0 : start;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(start, limit, sort);
        Page<Article> page = articleRepository.findAll(pageable);
        mav.addAttribute("page", page);
        return "/article/list";

    }

    /**
     * Description: 新增保存方法
     */
    @PostMapping("")
    public String saveArticle(Article model) throws Exception {
        articleRepository.save(model);
        return "redirect:/article/index";
    }

    /**
     * Description: 编辑视图
     */
    @GetMapping("/edit/{id}")
    public ModelAndView editArticle(@PathVariable("id") long id) throws Exception {
        Article model = articleRepository.findById(id);
        ModelAndView mav = new ModelAndView("article/edit");
        mav.addObject("article", model);
        return mav;
    }

    /**
     * Description: 修改方法
     */
    @PutMapping("/{id}")
    public String editArticleSave(Article model, long id) throws Exception {
        model.setId(id);
        articleRepository.save(model);
        return "redirect:/article/index";
    }

    @PostMapping("/{id}")
    public String del(@PathVariable("id") long id) throws Exception {
        articleRepository.deleteById(id);
        return "redirect:/article/index";
    }


    @GetMapping("/{id}")
    public ModelAndView getArticle(@PathVariable("id") Integer id) throws Exception {
        Article articles = articleRepository.findById((long) id);
        ModelAndView mav = new ModelAndView("article/show");
        mav.addObject("article", articles);
        return mav;
    }


}
