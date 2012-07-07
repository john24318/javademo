package com.wangyao.dp.behavioral.strategy;

public class Context {
	Strategy strategy;

	// Constructor
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int execute(int a, int b) {
		return this.strategy.execute(a, b);
	}

}
