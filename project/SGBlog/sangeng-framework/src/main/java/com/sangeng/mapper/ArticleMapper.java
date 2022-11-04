package com.sangeng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sangeng.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 文章表(Article)表数据库访问层
 *
 * @author 66
 * @since 2022-05-10 23:17:00
 */
public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> articleList(@Param("start") Integer start,@Param("limit") Integer pageSize,@Param("categoryId") Integer categoryId);
}

