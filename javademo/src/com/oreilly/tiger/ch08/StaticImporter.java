package com.oreilly.tiger.ch08;

import static java.lang.System.err;
import static java.lang.System.out;

import java.io.IOException;
import java.io.PrintStream;

public class StaticImporter {

	public static void writeError(PrintStream err, String msg) throws IOException {

		// Note that err in the parameter list overshadows the imported err
		err.println(msg);
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			err.println("Incorrect usage: java com.oreilly.tiger.ch08 [arg1] [arg2]");
			return;
		}

		out.println("Good morning, " + args[0]);
		out.println("Have a " + args[1] + " day!");

		try {
			writeError(System.out, "Error occurred.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}