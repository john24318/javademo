package com.wangyao.dp.behavioral.templatemethod;

/**
 * 意图：
 * 		定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。Template Method使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 * 适用性：
 * 		一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现。
 * 		
 * @author <a href="wangyao1981@gmail.com">wangyao</a>
 * @version $Id$
 * @since 1.0
 */
public abstract class AbstractClass {
	public void templateMethod() {
		// step by step template to solve something
		// implementor should follow those step
		opStep1();
		opStep2();
		opStep3();
	}

	protected abstract void opStep1();

	protected abstract void opStep2();

	protected abstract void opStep3();
}
