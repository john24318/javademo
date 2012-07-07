package demo.java.util.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	private final Lock lock = new ReentrantLock();
	private int value = 0;

	public int increment() {
		lock.lock();
		try {
			return ++value;
		} finally {
			lock.unlock();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
