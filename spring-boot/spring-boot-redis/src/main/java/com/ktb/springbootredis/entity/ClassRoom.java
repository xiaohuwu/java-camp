package com.ktb.springbootredis.entity;

import java.io.Serializable;

/**
 * (ClassRoom)实体类
 *
 * @author makejava
 * @since 2021-04-12 21:26:52
 */
public class ClassRoom implements Serializable {
    private static final long serialVersionUID = -73907353460962431L;

    private Integer id;

    private String classname;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

}
