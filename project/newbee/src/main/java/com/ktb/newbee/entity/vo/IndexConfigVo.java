
package com.ktb.newbee.entity.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * (IndexConfig)表实体类
 *
 * @author makejava
 * @since 2022-11-02 15:00:17
 */
@SuppressWarnings("serial")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_newbee_mall_index_config")
public class IndexConfigVo {

    @TableId("config_id")
    //首页配置项主键id
    private Long configId;
    //显示字符(配置搜索时不可为空，其他可为空)
    private String configName;
    //1-搜索框热搜 2-搜索下拉框热搜 3-(首页)热销商品 4-(首页)新品上线 5-(首页)为你推荐
    private Integer configType;
    //商品id 默认为0
    private Long goodsId;
    //点击后的跳转地址(默认不跳转)
    private String redirectUrl;
    //排序值(字段越大越靠前)
    private Integer configRank;
    //删除标识字段(0-未删除 1-已删除)
    private Integer isDeleted;
    //创建时间
    private Date createTime;
    //创建者id
    private Integer createUser;
    //最新修改时间
    private Date updateTime;
    //修改者id
    private Integer updateUser;

    private String    goodsName;

    private Integer sellingPrice;

}

