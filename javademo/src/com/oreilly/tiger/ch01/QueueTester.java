package com.oreilly.tiger.ch01;

import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTester {

	public Queue<String> q;

	public QueueTester() {
		q = new LinkedList<String>();
	}

	public void testFIFO(PrintStream out) throws IOException {
		q.add("First");
		q.add("Second");
		q.add("Third");

		Object o;
		while ((o = q.poll()) != null) {
			out.println(o);
		}
	}

	public static void main(String[] args) {
		QueueTester tester = new QueueTester();

		try {
			tester.testFIFO(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}