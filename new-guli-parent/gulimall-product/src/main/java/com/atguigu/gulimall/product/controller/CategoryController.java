package com.atguigu.gulimall.product.controller;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 商品三级分类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-10 16:07:09
 */
@RestController
@RequestMapping("product/category")
@Slf4j
public class CategoryController {

//    @Value("${coupon.user.name}")//从application.properties中获取//不要写user.name，他是环境里的变量
//    private String name;
//
//    @Value("${coupon.user.age}")
//    private Integer age;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){

        String[] names = applicationContext.getBeanDefinitionNames();
        int index = 1 ;
        for (String name : names) {
            log.info("{}: {}", index++ , name );
        }
        log.info("项目启动 容器注入javaBean:{}个.",names.length);
        return R.ok().put("page", names.length);
//        PageUtils page = categoryService.queryPage(params);
//
//        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);
        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
		categoryService.removeByIds(Arrays.asList(catIds));
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/list/tree")
    public R list_tree(){
        List<CategoryEntity> category =  categoryService.list_tree();
        return R.ok().put("data",category);
    }

}
