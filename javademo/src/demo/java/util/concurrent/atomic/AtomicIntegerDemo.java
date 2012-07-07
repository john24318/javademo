package demo.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	private AtomicInteger value = new AtomicInteger();

	public int next() {
		return value.incrementAndGet();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
