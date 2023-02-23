package com.ktb.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ktb.mybatisplus.entity.Product;
import com.ktb.mybatisplus.mapper.ProductMapper;
import com.ktb.mybatisplus.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2022-10-27
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService{

}
