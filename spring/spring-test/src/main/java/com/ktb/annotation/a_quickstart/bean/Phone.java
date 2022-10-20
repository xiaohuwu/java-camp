package com.ktb.annotation.a_quickstart.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //根据属性生成set，get方法
@NoArgsConstructor //生成空参构造
@AllArgsConstructor //生成全参构造
public class Phone {
    private double price;
    private String name;
    private String password;
    private String path;
}
