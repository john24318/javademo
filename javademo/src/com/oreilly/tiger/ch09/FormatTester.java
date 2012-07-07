package com.oreilly.tiger.ch09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FormatTester {

	public static void main(String[] args) {
		String filename = args[0];

		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);

			String line;
			int i = 1;
			while ((line = reader.readLine()) != null) {
				System.out.printf("Line %d: %s%n", i++, line);
			}

		} catch (Exception e) {
			System.err.printf("Unable to open file named '%s': %s", filename, e.getMessage());
		}
	}
}