package com.wangyao.dp.behavioral.strategy;

public class ConcreteStrategyMultiply implements Strategy {

	public int execute(int a, int b) {
		System.out.println("Called ConcreteStrategyC's execute()");
		return a * b; // Do a multiply with a and b
	}

}
