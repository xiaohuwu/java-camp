package com.atguigu.gulimall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }


    @Override
    public List<CategoryEntity> list_tree() {
        List<CategoryEntity> categoryEntities = categoryDao.selectList(null);
        List<CategoryEntity> level1Menus = categoryEntities.stream().filter((item) -> item.getParentCid() == 0)
                .map((item) -> {
                  item.setChildren(getChildren(item,categoryEntities));
                    return item;
                })
                .sorted((item,item1)->{ return item.getSort() - item1.getSort();})
                .collect(Collectors.toList());
        return level1Menus;
    }

    @Override
    public void removeByMenueIds(List<Long> asList) {
        categoryDao.deleteBatchIds(asList);
    }

    //这里用到了递归 仔细体会一下
    private List<CategoryEntity> getChildren(CategoryEntity item, List<CategoryEntity> categoryEntities) {
        ArrayList<CategoryEntity> list = new ArrayList<>();
         for (CategoryEntity categoryEntity : categoryEntities){
            if(categoryEntity.getParentCid().equals(item.getCatId())){
                list.add(categoryEntity);
                List<CategoryEntity> children = getChildren(categoryEntity, categoryEntities);
                categoryEntity.setChildren(children);
            }
         }
         return list;
    }

}