package com.wangyao.dp.behavioral.visitor;

public class ElementC implements Element {

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void operationC() {
		System.out.println("do C's job....such-and-such....");
	}
}
