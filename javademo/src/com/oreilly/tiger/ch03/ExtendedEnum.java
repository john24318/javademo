package com.oreilly.tiger.ch03;

public class ExtendedEnum /* extends Enum */{

	/**
	 * Compiler error: name() and all other Enum methods are final
	 * 
	 * public String name() { return "Extended " + super.name(); }
	 */
}