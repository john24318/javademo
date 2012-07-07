package sn.base.persistence.model;

import java.io.Serializable;

/**
 * PO抽象基类
 * 
 * @author wangyao
 * 
 */
public abstract class BaseObject implements Serializable {

	private static final long serialVersionUID = -5969387180599663267L;

	public abstract String toString();

	public abstract boolean equals(Object o);

	public abstract int hashCode();
}
