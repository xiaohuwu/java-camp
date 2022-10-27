package com.ktb.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.ktb.mybatisplus.model.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("t_user")
public class User {

    @TableId
    private Long uid;
    private String name;
    private Integer age;
    private String email;
    private SexEnum sex;


    @TableLogic
    public boolean isDelete;


//    public void fill_orders(List<Orders> orders) {
//        List<Orders> collect = orders.stream().filter((item) -> item.getUserId().equals(this.getId())).collect(Collectors.toList());
//        this.setOrders(collect);
//    }


}
