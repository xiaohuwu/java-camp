package com.ktb.model;

public class DruidDataSource {
    private String  driverClassName;
    private String  username;
    private String url;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    @Override
    public String toString() {
        return "DruidDataSource{" +
                "driverClassName='" + driverClassName + '\'' +
                ", username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
