package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.QrtzCronTriggersDao;
import com.atguigu.gulimall.product.entity.QrtzCronTriggersEntity;
import com.atguigu.gulimall.product.service.QrtzCronTriggersService;


@Service("qrtzCronTriggersService")
public class QrtzCronTriggersServiceImpl extends ServiceImpl<QrtzCronTriggersDao, QrtzCronTriggersEntity> implements QrtzCronTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzCronTriggersEntity> page = this.page(
                new Query<QrtzCronTriggersEntity>().getPage(params),
                new QueryWrapper<QrtzCronTriggersEntity>()
        );

        return new PageUtils(page);
    }

}