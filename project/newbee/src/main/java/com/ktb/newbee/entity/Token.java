package com.ktb.newbee.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@TableName("tb_newbee_mall_user_token")
@Data
@Accessors(chain = true)
public class Token {
    private Long userId;
    private String token;
    private LocalDateTime updateTime;
    private LocalDateTime expireTime;

}
