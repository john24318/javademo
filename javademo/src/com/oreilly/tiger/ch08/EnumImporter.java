package com.oreilly.tiger.ch08;

import static java.lang.System.out;
import static com.oreilly.tiger.ch03.Grade.*;

import java.io.IOException;
import java.io.PrintStream;
import com.oreilly.tiger.ch03.Student;

public class EnumImporter {

	private Student[] students = new Student[4];

	public EnumImporter() {
		students[0] = new Student("Brett", "McLaughlin");
		students[0].assignGrade(A);

		students[1] = new Student("Leigh", "McLaughlin");
		students[0].assignGrade(B);

		students[2] = new Student("Dean", "McLaughlin");
		students[0].assignGrade(C);

		students[3] = new Student("Robbie", "McLaughlin");
		students[0].assignGrade(INCOMPLETE);
	}

	public void printGrades(PrintStream out) throws IOException {
		for (Student student : students) {
			if ((student.getGrade() == INCOMPLETE) || (student.getGrade() == D)) {
				// Make this student retake this class
			}
		}
	}

	public static void main(String[] args) {
		try {
			EnumImporter importer = new EnumImporter();

			importer.printGrades(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}