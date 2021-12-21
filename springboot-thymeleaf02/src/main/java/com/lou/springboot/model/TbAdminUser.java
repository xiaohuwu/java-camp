package com.lou.springboot.model;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbAdminUser)实体类
 *
 * @author makejava
 * @since 2021-12-20 22:19:22
 */
public class TbAdminUser implements Serializable {
    private static final long serialVersionUID = -28326397025079642L;

    private Integer id;

    private String userName;

    private String passwordMd5;

    private String userToken;

    private Object isDeleted;

    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Object getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Object isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
