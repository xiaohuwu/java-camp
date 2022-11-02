package com.ktb.newbee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ktb.newbee.config.Result;
import com.ktb.newbee.dao.GoodsInfoDao;
import com.ktb.newbee.dao.IndexConfigDao;
import com.ktb.newbee.entity.Carousel;
import com.ktb.newbee.entity.GoodsInfo;
import com.ktb.newbee.entity.IndexConfig;
import com.ktb.newbee.entity.vo.HomeVo;
import com.ktb.newbee.service.CarouselService;
import com.ktb.newbee.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("homeService")
public class HomeServiceImpl implements HomeService {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private IndexConfigDao indexConfigDao;

    @Autowired
    private GoodsInfoDao goodsInfoDao;

    @Override
    public Result<Object> index() {
        LambdaQueryWrapper<Carousel> wrapper = new LambdaQueryWrapper<Carousel>();
        wrapper.eq(Carousel::getIsDeleted, 0);
        wrapper.last("limit 5");
        List<Carousel> carousels = carouselService.list(wrapper);

        //新品
        List<IndexConfig> newGoods = getIndexConfigs(4);
        List<IndexConfig> hotGoods = getIndexConfigs(3);
        List<IndexConfig> recommendGoods = getIndexConfigs(5);

        HomeVo homeVo = new HomeVo();
        homeVo.setCarousels(carousels);
        homeVo.setNewGoods(newGoods);
        homeVo.setHotGoods(hotGoods);
        homeVo.setRecommendGoods(recommendGoods);
        return Result.ok(homeVo);
    }


    private List<IndexConfig> getIndexConfigs(int configType) {
        LambdaQueryWrapper<IndexConfig> newWrapper = new LambdaQueryWrapper<IndexConfig>();
        newWrapper.eq(IndexConfig::getIsDeleted, 0);
        newWrapper.last("limit 5");
        newWrapper.eq(IndexConfig::getConfigType, configType);
        newWrapper.orderByDesc(true, IndexConfig::getConfigRank);
        List<IndexConfig> newGoods = indexConfigDao.selectList(newWrapper);
        List<Long> collect = newGoods.stream().map(IndexConfig::getGoodsId).collect(Collectors.toList());
        List<GoodsInfo> goodsInfos = goodsInfoDao.selectBatchIds(collect);
        newGoods.forEach(item -> {
            GoodsInfo goodsInfo = goodsInfos.stream().filter(goods -> goods.getGoodsId().equals(item.getGoodsId())).findFirst().orElse(null);
            if (goodsInfo != null) {
                item.setPrice(goodsInfo.getSellingPrice());
                item.setGoodsName(goodsInfo.getGoodsName());
            }
        });
        return newGoods;
    }
}
