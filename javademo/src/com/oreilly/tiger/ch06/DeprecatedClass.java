package com.oreilly.tiger.ch06;

public class DeprecatedClass {

	/**
	 * This method has now been deprecated in favor of doSomethingElse()
	 * 
	 * @deprecated Use doSomethingElse() instead
	 */

	@Deprecated
	public void doSomething() {
		// Really... do something...
	}

	public void doSomethingElse() {
		// Do something else (and presumably better)
	}
}