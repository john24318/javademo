package sn.core.persistence.model;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import sn.base.persistence.model.BaseObject;

/**
 * 通知数据模型
 * 
 * @author 王耀
 * 
 */
public class SnNotice extends BaseObject {
    private static final long serialVersionUID = -5403517537257789067L;

    // Fields

    private Integer noticeId;
    private Integer userId;
    private Integer stockId;
    private String title;
    private String content;
    private Short flag;
    private Boolean emailResult;
    private Boolean smsResult;
    private Date createTime;

    // VO
    private String email;
    private String userName;

    // Constructors

    /** default constructor */
    public SnNotice() {
    }

    /** full constructor */
    public SnNotice(Integer noticeId, Integer userId, Integer stockId, String title, String content, Short flag, Boolean emailResult,
            Boolean smsResult, Date createTime) {
        this.noticeId = noticeId;
        this.userId = userId;
        this.stockId = stockId;
        this.title = title;
        this.content = content;
        this.flag = flag;
        this.emailResult = emailResult;
        this.smsResult = smsResult;
        this.createTime = createTime;
    }

    // Property accessors

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStockId() {
        return this.stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Short getFlag() {
        return this.flag;
    }

    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getEmailResult() {
        return emailResult;
    }

    public void setEmailResult(Boolean emailResult) {
        this.emailResult = emailResult;
    }

    public Boolean getSmsResult() {
        return smsResult;
    }

    public void setSmsResult(Boolean smsResult) {
        this.smsResult = smsResult;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SnNotice))
            return false;

        if (this == o)
            return true;

        SnNotice other = (SnNotice) o;
        return new EqualsBuilder().append(this.getNoticeId(), other.getNoticeId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getNoticeId()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("noticeId", getNoticeId()).append("stockId", getStockId()).append("userId", getUserId())
                .append("title", getTitle()).append("content", getContent()).append("flag", getFlag())
                .append("emailResult", getEmailResult()).append("smsResult", getSmsResult()).append("createTime", getCreateTime()).toString();
    }

}