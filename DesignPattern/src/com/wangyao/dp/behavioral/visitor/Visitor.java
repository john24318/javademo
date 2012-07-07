package com.wangyao.dp.behavioral.visitor;

/**
 * 意图：
 * 		表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
 * 适用性：
 * 		
 * @author <a href="wangyao1981@gmail.com">wangyao</a>
 * @version $Id$
 * @since 1.0
 */
public interface Visitor {
	public void visit(ElementA element);

	public void visit(ElementB element);

	public void visit(ElementC element);
}
