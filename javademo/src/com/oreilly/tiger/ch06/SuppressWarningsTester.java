package com.oreilly.tiger.ch06;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarningsTester {

	/**
	 * Normal pre-1.5 method body
	 */
	@SuppressWarnings(value = { "unchecked" })
	public void nonGenericsMethod() {
		List wordList = new ArrayList();

		wordList.add("foo");
	}

}