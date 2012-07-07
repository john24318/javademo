package com.wangyao.dp.behavioral.visitor;

public class ElementB implements Element {

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void operationB() {
		System.out.println("do B's job....such-and-such....");
	}

}
