package com.oreilly.tiger.ch05;

import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class VarargsTester {

	public VarargsTester() {
	}

	private int[] getListOfNumbers() {
		int[] numbers = new int[] { 0, 2, 4, 6, 8, 10, 9, 7, 5, 3, 1 };
		return numbers;
	}

	private String print(Object... values) {
		StringBuilder sb = new StringBuilder();
		for (Object o : values) {
			sb.append(o.toString()).append(" ");
		}
		return sb.toString();
	}

	public void testMaxMethod(PrintStream out) throws IOException {
		int[] numbers = getListOfNumbers();

		int max = MathUtils.max(numbers);
		out.println("Max of list is: " + max);
	}

	public void testPrintMethod(PrintStream out) throws IOException {
		out.println(print("foo", 23, -12, 1.23, getListOfNumbers()));
	}

	public void testArrayArgs(PrintStream out) throws IOException {
		Object[] obj = new String[] { "Hello", "to", "all", "of", "you" };

		out.printf("%s\n", obj);
		out.printf("%s\n", (Object) obj);
	}

	public static void main(String[] args) {
		try {
			VarargsTester tester = new VarargsTester();

			tester.testMaxMethod(System.out);
			tester.testPrintMethod(System.out);
			tester.testArrayArgs(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}