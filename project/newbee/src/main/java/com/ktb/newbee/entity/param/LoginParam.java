package com.ktb.newbee.entity.param;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

@Data
public class LoginParam {
    @NonNull
    @ApiModelProperty("用户名")
    private String loginName;

    @NonNull
    @ApiModelProperty("密码")
    private String password;
}
