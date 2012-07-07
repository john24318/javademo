package demo.java.util.concurrent.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private int value;

	public void increment() {
		lock.writeLock().lock();
		try {
			value++;
		} finally {
			lock.writeLock().unlock();
		}
	}

	public int current() {
		lock.readLock().lock();
		try {
			return value;
		} finally {
			lock.readLock().unlock();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
