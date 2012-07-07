package com.oreilly.tiger.ch10;

import java.io.PrintStream;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

	private BlockingQueue<String> q;
	private PrintStream out;

	public Producer(BlockingQueue<String> q, PrintStream out) {
		setName("Producer");
		this.q = q;
		this.out = out;
	}

	public void run() {
		try {
			while (true) {
				q.put(produce());
			}
		} catch (InterruptedException e) {
			out.printf("%s interrupted: %s", getName(), e.getMessage());
		}
	}

	private String produce() {
		while (true) {
			double r = Math.random();

			// Only goes forward 1/10 of the time
			if ((r * 100) < 10) {
				String s = String.format("Inserted at %tc", new Date());
				return s;
			}
		}
	}
}