package com.ktb.newbee.config;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Result<T> {
    private static final long serialVersionUID = 1L;

    //业务码，比如成功、失败、权限不足等 code，可自行定义
    @ApiModelProperty("返回码")
    private int resultCode;
    //返回信息，后端在进行业务处理后返回给前端一个提示信息，可自行定义
    @ApiModelProperty("返回信息")
    private String message;
    //数据结果，泛型，可以是列表、单个对象、数字、布尔值等
    @ApiModelProperty("返回数据")
    private T data;

    public static<T> Result ok(T page1) {
       Result result = new Result();
        result.data = page1;
        result.resultCode = 200;
        result.message = "success";
        return result;
    }

    public static Result<Object> error(String err) {
        Result result = new Result();
        result.data = err;
        result.resultCode = 401;
        result.message = "login fail";
        return result;
    }


    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
