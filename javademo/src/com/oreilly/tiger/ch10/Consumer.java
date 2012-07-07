package com.oreilly.tiger.ch10;

import java.io.PrintStream;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

	private BlockingQueue<String> q;
	private PrintStream out;

	public Consumer(String name, BlockingQueue<String> q, PrintStream out) {
		setName(name);
		this.q = q;
		this.out = out;
	}

	public void run() {
		try {
			while (true) {
				process(q.take());
			}
		} catch (InterruptedException e) {
			out.printf("%s interrupted: %s", getName(), e.getMessage());
		}
	}

	private void process(Object obj) {
		out.printf("%s processing object:%n         '%s'%n", getName(), obj.toString());
	}
}