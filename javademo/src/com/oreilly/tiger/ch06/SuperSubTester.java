package com.oreilly.tiger.ch06;

public class SuperSubTester {

	public static void main(String[] args) {
		try {
			Sub sub = new Sub();
			sub.print(System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}