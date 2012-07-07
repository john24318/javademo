package com.wangyao.base.web.form;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.wangyao.base.persistence.Page;

/**
 * Form基类
 * 
 * @author 王耀
 * 
 */
public class BaseForm extends ValidatorForm implements Serializable {

    private static final long serialVersionUID = 3257005453799404851L;

    private Page pageInfo = new Page(); // 分页对象

    public Page getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Page pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        // 执行验证，验证规则定义在validation.xml中
        return super.validate(mapping, request);
    }
}
