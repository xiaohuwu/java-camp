package com.example.springbootblog.service.impl;

import com.example.springbootblog.entity.Blog;
import com.example.springbootblog.mapper.BlogMapper;
import com.example.springbootblog.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-09-18
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
