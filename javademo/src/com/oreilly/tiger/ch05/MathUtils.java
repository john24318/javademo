package com.oreilly.tiger.ch05;

public class MathUtils {

	public static int max(int... values) {
		if (values.length == 0) {
			throw new IllegalArgumentException("No values supplied.");
		}

		int max = Integer.MIN_VALUE;
		for (int i : values) {
			if (i > max)
				max = i;
		}
		return max;
	}
}