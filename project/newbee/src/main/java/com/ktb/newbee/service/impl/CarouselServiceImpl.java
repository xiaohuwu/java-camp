package com.ktb.newbee.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ktb.newbee.dao.CarouselDao;
import com.ktb.newbee.entity.Carousel;
import org.springframework.stereotype.Service;
import com.ktb.newbee.service.CarouselService;

/**
 * (TbNewbeeMallCarousel)表服务实现类
 *
 * @author makejava
 * @since 2022-11-02 14:34:55
 */
@Service("CarouselService")
public class CarouselServiceImpl extends ServiceImpl<CarouselDao, Carousel> implements CarouselService {

}

