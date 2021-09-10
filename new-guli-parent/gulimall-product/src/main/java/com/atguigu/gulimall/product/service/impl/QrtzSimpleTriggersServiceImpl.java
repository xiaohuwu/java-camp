package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.QrtzSimpleTriggersDao;
import com.atguigu.gulimall.product.entity.QrtzSimpleTriggersEntity;
import com.atguigu.gulimall.product.service.QrtzSimpleTriggersService;


@Service("qrtzSimpleTriggersService")
public class QrtzSimpleTriggersServiceImpl extends ServiceImpl<QrtzSimpleTriggersDao, QrtzSimpleTriggersEntity> implements QrtzSimpleTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzSimpleTriggersEntity> page = this.page(
                new Query<QrtzSimpleTriggersEntity>().getPage(params),
                new QueryWrapper<QrtzSimpleTriggersEntity>()
        );

        return new PageUtils(page);
    }

}