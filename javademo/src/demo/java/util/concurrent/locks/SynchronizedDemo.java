package demo.java.util.concurrent.locks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedDemo {

	private static Map<String, SynchronizedDemo> instanceMap = new HashMap<String, SynchronizedDemo>();

	private List<String> memberList = new ArrayList<String>();

	private int maxSize = 5;

	private SynchronizedDemo() {
	}

	private SynchronizedDemo(int maxSize) {
		if (maxSize > 0) {
			this.maxSize = maxSize;
		}
	}

	public static synchronized SynchronizedDemo getInstance(String name) {
		SynchronizedDemo instance = instanceMap.get(name);

		if (null == instance) {
			instance = new SynchronizedDemo();
			instanceMap.put(name, instance);
		}

		return instance;
	}

	public static void deleteInstance(String name) {
		synchronized (SynchronizedDemo.class) {
			instanceMap.remove(name);
		}
	}

	public synchronized void manufacture() {
		while (memberList.size() >= maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		char c = (char) (Math.random() * 26 + 'A');
		memberList.add(String.valueOf(c));

		notifyAll();
	}

	public String sell() {
		String product = null;

		synchronized (this) {

			while (memberList.size() < 1) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			product = memberList.remove(0);

			notifyAll();
		}

		return product;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (int i = 0; i <= 9; i++) {
			System.out.print(i);
		}
	}

}
