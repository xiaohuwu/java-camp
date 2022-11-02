package com.ktb.newbee.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * (GoodsInfo)表实体类
 *
 * @author makejava
 * @since 2022-11-02 15:04:01
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_newbee_mall_goods_info")
public class GoodsInfo{

    @TableId("goods_id")
    //商品表主键id
    private Long goodsId;
    //商品名
    private String goodsName;
    //商品简介
    private String goodsIntro;
    //关联分类id
    private Long goodsCategoryId;
    //商品主图
    private String goodsCoverImg;
    //商品轮播图
    private String goodsCarousel;
    //商品详情
    private String goodsDetailContent;
    //商品价格
    private Integer originalPrice;
    //商品实际售价
    private Integer sellingPrice;
    //商品库存数量
    private Integer stockNum;
    //商品标签
    private String tag;
    //商品上架状态 1-下架 0-上架
    private Integer goodsSellStatus;
    //添加者主键id
    private Integer createUser;
    //商品添加时间
    private Date createTime;
    //修改者主键id
    private Integer updateUser;
    //商品修改时间
    private Date updateTime;



    }

