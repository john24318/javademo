package com.wangyao.quickstart.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class HelloWorldTest extends TestCase {
	private static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("com/wangyao/quickstart/quickstart.xml");
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPrintHello() {
		HelloWorld hellWorld = (HelloWorld) context.getBean("helloWorld");
		hellWorld.printHello();
	}

}
