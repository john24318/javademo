package com.wangyao.dp.behavioral.visitor;

public class VisitorB implements Visitor {

	public void visit(ElementA element) {
		System.out.println("VisitorB is a hard worker....");
		element.operationA();
		System.out.println("I want to do some extra work on A....");
	}

	public void visit(ElementB element) {
		System.out.println("VisitorB is a hard worker....");
		element.operationB();
		System.out.println("I want to do some extra work on B....");
	}

	public void visit(ElementC element) {
		System.out.println("VisitorB is a hard worker....");
		element.operationC();
		System.out.println("I want to do some extra work on C....");
	}

}
