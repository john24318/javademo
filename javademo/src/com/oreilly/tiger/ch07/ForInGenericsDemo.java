package com.oreilly.tiger.ch07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ForInGenericsDemo {

	public static void main(String[] args) {

		// These are collections we�ll iterate over below.
		List<String> wordlist = new ArrayList<String>();
		Set<String> wordset = new HashSet<String>();

		// We start with a basic loop over the elements of an array.
		// The body of the loop is executed once for each element of args[].
		// Each time through one element is assigned to the variable word.
		System.out.println("Assigning arguments to lists...");
		for (String word : args) {
			System.out.print(word + " ");
			wordlist.add(word);
			wordset.add(word);
		}

		System.out.println();

		// Iterate through the elements of the List now.
		// Since lists have an order, these words should appear as above
		System.out.println("Printing words from wordlist " + "(ordered, with duplicates)...");
		for (String word : wordlist) {
			System.out.print(word + " ");
		}

		System.out.println();

		// Do the same for the Set. The loop looks the same but by virtue of
		// using a Set, we lose the word order and also discard duplicates.
		System.out.println("Printing words from wordset " + "(unordered, no duplicates)...");
		for (String word : wordset) {
			System.out.print(word + " ");
		}
	}
}
