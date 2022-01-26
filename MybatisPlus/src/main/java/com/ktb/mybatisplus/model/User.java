package com.ktb.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
public class User {

    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;

    @TableField(exist = false)
    private List<Orders> orders;

    @TableField("address")
    private String addressStr;


    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public void fill_orders(List<Orders> orders) {
        List<Orders> collect = orders.stream().filter((item) -> item.getUserId().equals(this.getId())).collect(Collectors.toList());
        this.setOrders(collect);
    }


}
