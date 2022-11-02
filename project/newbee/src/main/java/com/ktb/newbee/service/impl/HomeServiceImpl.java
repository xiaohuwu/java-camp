package com.ktb.newbee.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ktb.newbee.config.Result;
import com.ktb.newbee.dao.GoodsInfoDao;
import com.ktb.newbee.dao.IndexConfigDao;
import com.ktb.newbee.entity.Carousel;
import com.ktb.newbee.entity.IndexConfig;
import com.ktb.newbee.entity.vo.HomeVo;
import com.ktb.newbee.entity.vo.IndexConfigVo;
import com.ktb.newbee.service.CarouselService;
import com.ktb.newbee.service.HomeService;
import com.ktb.newbee.util.BeanCopyUtils;
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
        List<IndexConfigVo> newGoodsVo = getIndexConfigVos(4);
        List<IndexConfigVo> hotGoodsVo = getIndexConfigVos(3);
        List<IndexConfigVo> recommendGoodsVo = getIndexConfigVos(5);

        HomeVo homeVo = new HomeVo();
        homeVo.setCarousels(carousels);
        homeVo.setNewGoods(newGoodsVo);
        homeVo.setHotGoods(hotGoodsVo);
        homeVo.setRecommendGoods(recommendGoodsVo);
        return Result.ok(homeVo);
    }

    private List<IndexConfigVo> getIndexConfigVos(int configType) {
        List<IndexConfig> newGoods = indexConfigDao.getIndexConfigs(configType);
        List<IndexConfigVo> collect = newGoods.stream().map((item) -> {
            IndexConfigVo vo = BeanCopyUtils.copyBean(item, IndexConfigVo.class);
            vo.setGoodsName(item.getGoodsInfo().getGoodsName());
            vo.setSellingPrice(item.getGoodsInfo().getSellingPrice());
            return vo;
        }).collect(Collectors.toList());
        return collect;
    }
}
