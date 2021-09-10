package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.QrtzBlobTriggersDao;
import com.atguigu.gulimall.product.entity.QrtzBlobTriggersEntity;
import com.atguigu.gulimall.product.service.QrtzBlobTriggersService;


@Service("qrtzBlobTriggersService")
public class QrtzBlobTriggersServiceImpl extends ServiceImpl<QrtzBlobTriggersDao, QrtzBlobTriggersEntity> implements QrtzBlobTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzBlobTriggersEntity> page = this.page(
                new Query<QrtzBlobTriggersEntity>().getPage(params),
                new QueryWrapper<QrtzBlobTriggersEntity>()
        );

        return new PageUtils(page);
    }

}