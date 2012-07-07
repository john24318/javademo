package com.oreilly.tiger.ch01;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTester {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(20, new Comparator<Integer>() {
			public int compare(Integer i, Integer j) {
				int result = i % 2 - j % 2;
				if (result == 0)
					result = i - j;
				return result;
			}
		});

		// Fill up with data, in an odd order
		for (int i = 0; i < 20; i++) {
			pq.offer(20 - i);
		}

		// Print out and check ordering
		for (int i = 0; i < 20; i++) {
			System.out.println(pq.poll());
		}
	}
}