package com.wangyao.app.persistence.model;

import java.sql.Blob;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.wangyao.base.persistence.model.BaseObject;

public class Photo extends BaseObject {
    private static final long serialVersionUID = -3076832826335670716L;
    private Integer id;
    private String name;
    private Blob image;
    private String type;
    private Integer size;
    private Date createTime;

    public boolean equals(Object o) {
        if (!(o instanceof Photo))
            return false;

        if (this == o)
            return true;

        Photo other = (Photo) o;
        return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getId()).toHashCode();
    }

    public String toString() {
        return new ToStringBuilder(this).append("id", getId()).append("name", getName()).append("type", getType()).append("size", getSize())
                .append("createTime", getCreateTime()).toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
