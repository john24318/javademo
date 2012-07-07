package com.wangyao.dp.behavioral.strategy;

public class ConcreteStrategySubtract implements Strategy {

	public int execute(int a, int b) {
		System.out.println("Called ConcreteStrategyB's execute()");
		return (a - b); // Do a subtraction with a and b
	}

}
