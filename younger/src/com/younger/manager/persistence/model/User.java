package com.younger.manager.persistence.model;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.younger.base.persistence.model.BaseObject;

public class User extends BaseObject implements Cloneable {

    private static final long serialVersionUID = 323935725877373155L;

    private Integer userId;// 用户ID（主键）
    private String userLogin; // 登录用户名
    private String userPass; // 用户密码
    private String userNicename;// 用户昵称
    private Integer userStatus;// 用户状态
    private Date userRegistered;// 注册时间
    private Date userLastlogin;// 登录时间

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object o) {
        if (!(o instanceof User))
            return false;

        if (this == o)
            return true;

        User other = (User) o;
        return new EqualsBuilder().append(this.getUserId(), other.getUserId()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getUserId()).toHashCode();
    }

    public String toString() {
        return new ToStringBuilder(this).append("userId", getUserId()).append("userLogin", getUserLogin()).append("userNicename",
                getUserNicename()).append("userStatus", getUserStatus()).append("userRegistered", getUserRegistered()).append(
                "userLastlogin", getUserLastlogin()).toString();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserNicename() {
        return userNicename;
    }

    public void setUserNicename(String userNicename) {
        this.userNicename = userNicename;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(Date userRegistered) {
        this.userRegistered = userRegistered;
    }

    public Date getUserLastlogin() {
        return userLastlogin;
    }

    public void setUserLastlogin(Date userLastlogin) {
        this.userLastlogin = userLastlogin;
    }
}
