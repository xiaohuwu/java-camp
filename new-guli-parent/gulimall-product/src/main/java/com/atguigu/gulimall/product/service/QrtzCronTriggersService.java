package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.QrtzCronTriggersEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2021-09-09 23:59:24
 */
public interface QrtzCronTriggersService extends IService<QrtzCronTriggersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
