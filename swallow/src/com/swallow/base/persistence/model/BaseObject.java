package com.swallow.base.persistence.model;

import java.io.Serializable;

/**
 * PO抽象基类
 * 
 * @author wangyao
 * 
 */
public abstract class BaseObject implements Serializable {

    public abstract String toString();

    public abstract boolean equals(Object o);

    public abstract int hashCode();
}
