package com.ktb.model;

public class ModelAttributeUser {
    private String loginname;
    private String password;
    private String username;

    public ModelAttributeUser() {
        super();
    }

    public ModelAttributeUser(String loginname, String password, String username) {
        super();
        this.loginname = loginname;
        this.password = password;
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
