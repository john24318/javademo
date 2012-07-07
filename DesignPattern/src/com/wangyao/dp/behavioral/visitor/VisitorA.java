package com.wangyao.dp.behavioral.visitor;

public class VisitorA implements Visitor {

	public void visit(ElementA element) {
		element.operationA();
	}

	public void visit(ElementB element) {
		element.operationB();
	}

	public void visit(ElementC element) {
		element.operationC();
	}

}
