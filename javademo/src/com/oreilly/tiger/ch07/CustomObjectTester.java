package com.oreilly.tiger.ch07;

import java.io.IOException;
import java.io.PrintStream;

public class CustomObjectTester {

	/** A custom object that extends List */
	private GuitarManufacturerList manufacturers;

	public CustomObjectTester() {
		this.manufacturers = new GuitarManufacturerList();
	}

	/**
	 * <p>
	 * Test iterating over an object that extends List
	 * </p>
	 */
	public void testListExtension(PrintStream out) throws IOException {
		// Add some items for good measure
		manufacturers.add("Epiphone Guitars");
		manufacturers.add("Gibson Guitars");

		// Iterate with for/in
		for (String manufacturer : manufacturers) {
			out.println(manufacturer);
		}
	}

	public static void main(String[] args) {
		try {
			CustomObjectTester tester = new CustomObjectTester();

			tester.testListExtension(System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}