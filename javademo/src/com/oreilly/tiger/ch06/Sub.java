package com.oreilly.tiger.ch06;

import java.io.IOException;
import java.io.PrintStream;

public class Sub extends Super {

	public void print(PrintStream out) throws IOException {
		out.println("Sub printing...");
	}
}