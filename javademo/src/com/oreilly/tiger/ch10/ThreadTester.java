package com.oreilly.tiger.ch10;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import static java.util.concurrent.TimeUnit.*;

public class ThreadTester {

	private int[] posArray = new int[] { 1, 3, 6, 3, 4, 2, 5 };
	private int[] negArray = new int[] { -2, -8, -3, -9, -10 };

	public ThreadTester() {
	}

	public void testBubbleSort(PrintStream out) throws IOException {
		Thread t1 = new BubbleSortThread(posArray);
		t1.start();

		out.println("Testing with postive numbers...");
		// Wait for the thread to complete
		try {
			t1.join();
			printArray(posArray, out);
		} catch (InterruptedException ignored) {
		}

		Thread t2 = new BubbleSortThread(negArray);
		t2.start();

		out.println("Testing with negative numbers...");
		try {
			t2.join();
			printArray(negArray, out);
		} catch (InterruptedException ignored) {
		}
	}

	private void printArray(int[] a, PrintStream out) throws IOException {
		for (int n : a) {
			out.println(n);
		}
		out.println();
	}

	public void testQueue(PrintStream out) throws IOException {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
		Producer p = new Producer(queue, out);
		Consumer c1 = new Consumer("Consumer 1", queue, out);
		Consumer c2 = new Consumer("Consumer 2", queue, out);
		Consumer c3 = new Consumer("Consumer 3", queue, out);
		Consumer c4 = new Consumer("Consumer 4", queue, out);

		p.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		try {
			SECONDS.sleep(10);
		} catch (InterruptedException ignored) {
		}

		// Finish up with these threads
		p.stop();
		c1.stop();
		c2.stop();
		c3.stop();
		c4.stop();
	}

	public void testCallable(PrintStream out) throws IOException {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<BigInteger> prime1 = service.submit(new RandomPrimeSearch(512));
		Future<BigInteger> prime2 = service.submit(new RandomPrimeSearch(512));
		Future<BigInteger> prime3 = service.submit(new RandomPrimeSearch(512));

		try {
			BigInteger bigger = (prime1.get().multiply(prime2.get())).multiply(prime3.get());
			out.println(bigger);
		} catch (InterruptedException e) {
			e.printStackTrace(out);
		} catch (ExecutionException e) {
			e.printStackTrace(out);
		}
	}

	public static void main(String[] args) {
		ThreadTester tester = new ThreadTester();

		try {
			// tester.testBubbleSort(System.out);
			// tester.testQueue(System.out);
			tester.testCallable(System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}