package com.oreilly.tiger.ch02;

import java.util.ArrayList;
import java.util.List;

public class BadIdea {

	private static List<Integer> ints = new ArrayList<Integer>();

	public static void fillList(List<Integer> list) {
		for (Integer i : list) {
			ints.add(i);
		}
	}

	public static void printList() {
		for (Integer i : ints) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		List<Integer> myInts = new ArrayList<Integer>();
		myInts.add(1);
		myInts.add(2);
		myInts.add(3);

		System.out.println("Filling list and printing in normal way...");
		fillList(myInts);
		printList();

		try {
			List list = (List) BadIdea.class.getDeclaredField("ints").get(null);
			list.add("Illegal Value!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Printing with illegal values in list...");
		printList();
	}
}