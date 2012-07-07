package com.oreilly.tiger.ch02;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GenericsTester {

	public GenericsTester() {
	}

	public void testTypeSafeMaps(PrintStream out) throws IOException {
		Map<Integer, Integer> squares = new HashMap<Integer, Integer>();

		for (int i = 0; i < 100; i++) {
			squares.put(i, i * i);
		}

		for (int i = 0; i < 10; i++) {
			int n = i * 3;
			out.println("The square of " + n + " is " + squares.get(n));
		}
	}

	public void testTypeSafeLists(PrintStream out) throws IOException {
		List listOfStrings = getListOfStrings();
		for (Iterator i = listOfStrings.iterator(); i.hasNext();) {
			String item = (String) i.next();

			// Work with that string
		}

		List<String> onlyStrings = new LinkedList<String>();
		onlyStrings.add("Legal addition");
		/**
		 * Uncomment these two lines for an error onlyStrings.add(new StringBuilder("Illegal Addition"));
		 * onlyStrings.add(25);
		 */
	}

	public void testTypeSafeIterators(PrintStream out) throws IOException {
		List<String> listOfStrings = new LinkedList<String>();
		listOfStrings.add("Happy");
		listOfStrings.add("Birthday");
		listOfStrings.add("To");
		listOfStrings.add("You");

		for (Iterator<String> i = listOfStrings.iterator(); i.hasNext();) {
			String s = i.next();
			out.println(s);
		}

		printListOfStrings(getListOfStrings(), out);
	}

	private List getList() {
		List list = new LinkedList();
		list.add(3);
		list.add("Blind");
		list.add("Mice");

		return list;
	}

	private List<String> getListOfStrings() {
		List<String> list = new LinkedList<String>();
		list.add("Hello");
		list.add("World");
		list.add("How");
		list.add("Are");
		list.add("You?");

		return list;
	}

	public void testTypeSafeReturnValues(PrintStream out) throws IOException {
		List<String> strings = getListOfStrings();

		for (String s : strings) {
			out.println(s);
		}
	}

	private void printListOfStrings(List<String> list, PrintStream out) throws IOException {

		for (Iterator<String> i = list.iterator(); i.hasNext();) {
			out.println(i.next());
		}
	}

	public void printList(List<?> list, PrintStream out) throws IOException {
		for (Iterator<?> i = list.iterator(); i.hasNext();) {
			out.println(i.next().toString());
		}
	}

	public static void main(String[] args) {
		GenericsTester tester = new GenericsTester();

		try {
			tester.testTypeSafeLists(System.out);
			tester.testTypeSafeMaps(System.out);
			tester.testTypeSafeIterators(System.out);
			tester.testTypeSafeReturnValues(System.out);

			List<Integer> ints = new LinkedList<Integer>();
			ints.add(1);
			ints.add(2);
			ints.add(3);
			tester.printList(ints, System.out);

			/**
			 * Uncomment for an error NumberBox<String> illegal = new NumberBox<String>();
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}