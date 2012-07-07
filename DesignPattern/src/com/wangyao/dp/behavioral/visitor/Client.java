package com.wangyao.dp.behavioral.visitor;

public class Client {

	public static void main(String[] args) {
		// know nothing about their type
		// after storing them into Element array
		Element[] list = { new ElementA(), new ElementB(), new ElementC() };

		System.out.println("visitorA is coming.......");
		Visitor visitorA = new VisitorA();
		for (int i = 0; i < list.length; i++)
			list[i].accept(visitorA);

		System.out.println("\nvisitorB is coming.......");
		Visitor visitorB = new VisitorB();
		for (int i = 0; i < list.length; i++)
			list[i].accept(visitorB);
	}
}
