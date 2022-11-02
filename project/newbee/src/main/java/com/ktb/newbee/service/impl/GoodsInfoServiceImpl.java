package com.ktb.newbee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktb.newbee.dao.GoodsInfoDao;
import com.ktb.newbee.entity.GoodsInfo;
import com.ktb.newbee.service.GoodsInfoService;
import org.springframework.stereotype.Service;

/**
 * (GoodsInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-11-02 15:04:01
 */
@Service("goodsInfoService")
public class GoodsInfoServiceImpl extends ServiceImpl<GoodsInfoDao, GoodsInfo> implements GoodsInfoService {

}

