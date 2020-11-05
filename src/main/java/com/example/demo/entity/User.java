package com.example.demo.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2020-11-02 09:02:53
 */
public class User implements Serializable {
    private static final long serialVersionUID = 382327077812824312L;

    private Integer userId;

    private String userName;

    private String userCompany;

    private String userOpenid;

    private String userSessionkey;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public String getUserSessionkey() {
        return userSessionkey;
    }

    public void setUserSessionkey(String userSessionkey) {
        this.userSessionkey = userSessionkey;
    }

}