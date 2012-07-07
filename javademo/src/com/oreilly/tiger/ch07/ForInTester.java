package com.oreilly.tiger.ch07;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ForInTester {

	public ForInTester() {
	}

	public List getList() {
		List list = new LinkedList();

		for (int i = 1; i <= 100; i++) {
			list.add("Item " + i);
		}

		return list;
	}

	/**
	 * <p>
	 * Test a very basic, pre-Java 1.5 for loop
	 * </p>
	 */
	public void testForLoop(PrintStream out) throws IOException {
		List list = getList(); // initialize this list elsewhere

		for (Iterator i = list.iterator(); i.hasNext();) {
			Object listElement = i.next();
			out.println(listElement.toString());

			// Do something else with this list object
		}
	}

	/**
	 * <p>
	 * Test a very basic, Java 1.5 for/in loop
	 * </p>
	 */
	public void testForInLoop(PrintStream out) throws IOException {
		List list = getList(); // initialize this list elsewhere

		for (Object listElement : list) {
			out.println(listElement.toString());

			// Do something else with this list object
		}
	}

	/**
	 * <p>
	 * Test a simple array iteration
	 * </p>
	 */
	public void testArrayLooping(PrintStream out) throws IOException {
		int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };

		// Print the primes out using a for/in loop
		for (int n : primes) {
			out.println(n);
		}
	}

	/**
	 * <p>
	 * Test an object array iteration
	 * </p>
	 */
	public void testObjectArrayLooping(PrintStream out) throws IOException {
		List[] list_array = new List[3];

		list_array[0] = getList();
		list_array[1] = getList();
		list_array[2] = getList();

		for (List l : list_array) {
			out.println(l.getClass().getName());
		}
	}

	/**
	 * <p>
	 * Show list position in a loop (not possible with for/in)
	 * </p>
	 */
	public void determineListPosition(PrintStream out, String[] args) throws IOException {

		List<String> wordList = new LinkedList<String>();

		// Impossible to assign the words, since the iterator is used
		for (int i = 0; i < args.length; i++) {
			wordList.add("word " + (i + 1) + ": '" + args[i] + "'");
		}

		// You can print the words using for/in, but not assign them
		for (String word : wordList) {
			out.println(word);
		}

		StringBuffer longList = new StringBuffer();
		for (int i = 0, len = wordList.size(); i < len; i++) {
			if (i < (len - 1)) {
				longList.append(wordList.get(i)).append(", ");
			} else {
				longList.append(wordList.get(i));
			}
		}
		out.println(longList);
	}

	/**
	 * <p>
	 * for/in can't remove items using an Iterator
	 * </p>
	 */
	public void removeListItems(PrintStream out, String[] args) throws IOException {

		List<String> wordList = new LinkedList<String>();

		// Assign some words
		for (int i = 0; i < args.length; i++) {
			wordList.add("word " + (i + 1) + ": '" + args[i] + "'");
		}

		// Remove all words with "1" in them. Impossible with for/in
		for (Iterator i = wordList.iterator(); i.hasNext();) {
			String word = (String) i.next();
			if (word.indexOf("1") != -1) {
				i.remove();
			}
		}

		// You can print the words using for/in
		for (String word : wordList) {
			out.println(word);
		}
	}

	public static void main(String[] args) {
		try {
			ForInTester tester = new ForInTester();

			tester.testForLoop(System.out);
			tester.testForInLoop(System.out);

			tester.testArrayLooping(System.out);
			tester.testObjectArrayLooping(System.out);

			tester.determineListPosition(System.out, args);
			tester.removeListItems(System.out, args);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}