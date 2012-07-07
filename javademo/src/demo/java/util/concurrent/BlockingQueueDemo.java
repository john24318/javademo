package demo.java.util.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueue<Character> q = new ArrayBlockingQueue<Character>(1);
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
}

/**
 * 生产者
 * 
 * @author wangyao
 * 
 */
class Producer implements Runnable {
	private final BlockingQueue<Character> queue;

	Producer(BlockingQueue<Character> q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				Character c = (char) (Math.random() * 26 + 'A');
				System.out.println("生产：" + c);
				queue.put(c);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}

/**
 * 消费者
 * 
 * @author wangyao
 * 
 */
class Consumer implements Runnable {
	private final BlockingQueue<Character> queue;

	Consumer(BlockingQueue<Character> q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				Character c = queue.take();
				System.out.println("消费：" + c);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}