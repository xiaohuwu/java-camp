package com.example.springboottest.dto;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class LoginDto {

    @NotNull(message = "昵称不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;

}
