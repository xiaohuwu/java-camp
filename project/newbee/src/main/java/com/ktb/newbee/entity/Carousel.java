package com.ktb.newbee.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * (TbNewbeeMallCarousel)表实体类
 *
 * @author makejava
 * @since 2022-11-02 14:34:53
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_newbee_mall_carousel")
public class Carousel  {

    @TableId("carousel_id")
    //首页轮播图主键id
    private Integer carouselId;
    //轮播图
    private String carouselUrl;
    //点击后的跳转地址(默认不跳转)
    private String redirectUrl;
    //排序值(字段越大越靠前)
    private Integer carouselRank;
    //删除标识字段(0-未删除 1-已删除)
    private Integer isDeleted;
    //创建时间
    private Date createTime;
    //创建者id
    private Integer createUser;
    //修改时间
    private Date updateTime;
    //修改者id
    private Integer updateUser;


}

