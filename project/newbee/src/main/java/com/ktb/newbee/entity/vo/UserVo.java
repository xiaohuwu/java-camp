package com.ktb.newbee.entity.vo;

import com.ktb.newbee.entity.User;

public class UserVo extends User {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
