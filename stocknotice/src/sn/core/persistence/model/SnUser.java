package sn.core.persistence.model;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import sn.base.persistence.model.BaseObject;

/**
 * 用户数据模型
 * 
 * @author 王耀
 * 
 */
public class SnUser extends BaseObject {
    private static final long serialVersionUID = 3863373176963993220L;

    // Fields

    private Integer userId;
    private String login;
    private String password;
    private String email;
    private String mobilePhoneNumber;
    private Date registered;
    private String activeCode;
    private Short state;
    private Date lastLoginTime;
    private String lastLoginIp;

    // Constructors

    /** default constructor */
    public SnUser() {
    }

    /** minimal constructor */
    public SnUser(Integer userId, String login, String password, String email, String mobilePhoneNumber, Date registered, Short state) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.registered = registered;
        this.state = state;
    }

    /** full constructor */
    public SnUser(Integer userId, String login, String password, String email, String mobilePhoneNumber, Date registered, String activeCode,
            Short state, Date lastLoginTime, String lastLoginIp) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.registered = registered;
        this.activeCode = activeCode;
        this.state = state;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
    }

    // Property accessors

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SnUser))
            return false;

        if (this == o)
            return true;

        SnUser other = (SnUser) o;
        return new EqualsBuilder().append(this.getUserId(), other.getUserId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getUserId()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("userId", getUserId()).append("login", getLogin()).append("password", getPassword()).append(
                "email", getEmail()).append("mobilePhoneNumber", getMobilePhoneNumber()).append("registered", getRegistered()).append(
                "activeCode", getActiveCode()).append("state", getState()).append("lastLoginTime", getLastLoginTime()).append("lastLoginIp",
                getLastLoginIp()).toString();
    }

}