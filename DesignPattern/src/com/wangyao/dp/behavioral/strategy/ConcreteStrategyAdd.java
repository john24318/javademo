package com.wangyao.dp.behavioral.strategy;

public class ConcreteStrategyAdd implements Strategy {

	public int execute(int a, int b) {
		System.out.println("Called ConcreteStrategyA's execute()");
		return (a + b); // Do an addition with a and b
	}

}
