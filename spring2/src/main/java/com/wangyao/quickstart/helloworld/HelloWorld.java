package com.wangyao.quickstart.helloworld;

public class HelloWorld {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello " + name + "!");
	}
}
