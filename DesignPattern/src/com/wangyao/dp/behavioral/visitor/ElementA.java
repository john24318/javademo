package com.wangyao.dp.behavioral.visitor;

public class ElementA implements Element {

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void operationA() {
		System.out.println("do A's job....such-and-such....");
	}
}
