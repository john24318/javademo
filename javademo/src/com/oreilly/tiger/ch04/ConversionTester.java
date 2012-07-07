package com.oreilly.tiger.ch04;

public class ConversionTester {

	public static void main(String[] args) {
		Integer i = 0;

		// Boxing
		int foo = 0;
		Integer integer = foo;

		// Simple Unboxing
		int bar = integer;

		Integer counter = 1; // boxing
		int counter2 = counter; // unboxing

		while (true) {
			System.out.printf("Iteration %d%n", counter++);
			if (counter > 1000)
				break;
		}

		Boolean case1 = true;
		Boolean case2 = true;
		boolean case3 = false;

		Boolean result = (case1 || case2) && case3;

		Integer i1 = 256;
		Integer i2 = 256;

		if (i1 == i2)
			System.out.println("Equal!");
		else
			System.out.println("Not equal!");

		Boolean arriving = false;
		Boolean late = true;

		System.out.println(arriving ? (late ? "It's about time!" : "Hello!") : (late ? "Better hurry!" : "Goodbye"));

		Integer peopleInRoom = 0;
		int maxCapacity = 100;
		boolean timeToLeave = false;
		while (peopleInRoom < maxCapacity) {
			if (arriving) {
				System.out.println("It's good to see you.");
				peopleInRoom++;
			} else {
				peopleInRoom--;
			}
			if (timeToLeave) {
				do {
					System.out.printf("Hey, person %d, get out!%n", peopleInRoom);
					peopleInRoom--;
				} while (peopleInRoom > 0);
			}
		}
	}
}