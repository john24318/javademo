package com.wangyao.dp.behavioral.strategy;

public class StrategyExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Context context;

		// Three contexts following different strategies
		context = new Context(new ConcreteStrategyAdd());
		int resultA = context.execute(3, 4);
		System.out.println(resultA);

		context = new Context(new ConcreteStrategySubtract());
		int resultB = context.execute(3, 4);
		System.out.println(resultB);

		context = new Context(new ConcreteStrategyMultiply());
		int resultC = context.execute(3, 4);
		System.out.println(resultC);

	}

}
