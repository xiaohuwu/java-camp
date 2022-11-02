package com.ktb.newbee.entity.vo;

import com.ktb.newbee.entity.Carousel;
import com.ktb.newbee.entity.IndexConfig;
import lombok.Data;

import java.util.List;

@Data
public class HomeVo {
    private List<Carousel> carousels;
    private List<IndexConfig> newGoods;
    private List<IndexConfig> hotGoods;
    private List<IndexConfig> recommendGoods;

    public List<Carousel> getCarousels() {
        return carousels;
    }

    public void setCarousels(List<Carousel> carousels) {
        this.carousels = carousels;
    }

}
