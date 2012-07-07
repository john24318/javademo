package com.oreilly.tiger.ch08;

import java.util.Arrays;

/** Uncommenting this next line creates a namespace error
 import com.oreilly.tiger.ch08.Arrays;
 */

import static java.util.Arrays.sort;
import static java.util.Collections.sort;

/**
 * Uncommenting this next line creates a _potential_ namespace error import static com.oreilly.tiger.ch08.Arrays.sort;
 */

public class SortImporter {

	public static void main(String[] args) {
		float[] f = new float[] { 5, 4, 6, 3, 2, 1 };

		// sort(f);
	}
}