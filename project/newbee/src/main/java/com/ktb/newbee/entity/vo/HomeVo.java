package com.ktb.newbee.entity.vo;

import com.ktb.newbee.entity.Carousel;
import lombok.Data;

import java.util.List;

@Data
public class HomeVo {
    private List<Carousel> carousels;
    private List<IndexConfigVo> newGoods;
    private List<IndexConfigVo> hotGoods;
    private List<IndexConfigVo> recommendGoods;

    public List<Carousel> getCarousels() {
        return carousels;
    }

    public void setCarousels(List<Carousel> carousels) {
        this.carousels = carousels;
    }

}
