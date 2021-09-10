package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.QrtzSchedulerStateDao;
import com.atguigu.gulimall.product.entity.QrtzSchedulerStateEntity;
import com.atguigu.gulimall.product.service.QrtzSchedulerStateService;


@Service("qrtzSchedulerStateService")
public class QrtzSchedulerStateServiceImpl extends ServiceImpl<QrtzSchedulerStateDao, QrtzSchedulerStateEntity> implements QrtzSchedulerStateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<QrtzSchedulerStateEntity> page = this.page(
                new Query<QrtzSchedulerStateEntity>().getPage(params),
                new QueryWrapper<QrtzSchedulerStateEntity>()
        );

        return new PageUtils(page);
    }

}