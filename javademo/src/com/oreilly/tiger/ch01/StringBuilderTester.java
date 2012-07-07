package com.oreilly.tiger.ch01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringBuilderTester {

	public static String appendItems(List<String> list) {
		StringBuilder b = new StringBuilder();

		for (Iterator<String> i = list.iterator(); i.hasNext();) {
			b.append(i.next()).append(" ");
		}

		return b.toString();
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("I");
		list.add("play");
		list.add("Bourgeois");
		list.add("guitars");
		list.add("and");
		list.add("Huber");
		list.add("banjos");

		System.out.println(StringBuilderTester.appendItems(list));
	}
}