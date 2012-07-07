package com.oreilly.tiger.ch06;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.AnnotatedElement;
import java.lang.annotation.Annotation;

public class ReflectionTester {

	public ReflectionTester() {
	}

	public void testAnnotationPresent(PrintStream out) throws IOException {
		Class c = Super.class;
		boolean inProgress = c.isAnnotationPresent(InProgress.class);
		if (inProgress) {
			out.println("Super is In Progress");
		} else {
			out.println("Super is not In Progress");
		}
	}

	public void testInheritedAnnotation(PrintStream out) throws IOException {
		Class c = Sub.class;
		boolean inProgress = c.isAnnotationPresent(InProgress.class);
		if (inProgress) {
			out.println("Sub is In Progress");
		} else {
			out.println("Sub is not In Progress");
		}
	}

	public void testGetAnnotation(PrintStream out) throws IOException, NoSuchMethodException {

		Class c = AnnotationTester.class;
		AnnotatedElement element = c.getMethod("calculateInterest", float.class, float.class);

		GroupTODO groupTodo = element.getAnnotation(GroupTODO.class);
		String assignedTo = groupTodo.assignedTo();

		out.println("TODO Item on Annotation Tester is assigned to: '" + assignedTo + "'");
	}

	public void printAnnotations(AnnotatedElement e, PrintStream out) throws IOException {

		out.printf("Printing annotations for '%s'%n%n", e.toString());

		Annotation[] annotations = e.getAnnotations();
		for (Annotation a : annotations) {
			out.printf("    * Annotation '%s' found%n", a.annotationType().getName());
		}
	}

	public static void main(String[] args) {
		try {
			ReflectionTester tester = new ReflectionTester();

			tester.testAnnotationPresent(System.out);
			tester.testInheritedAnnotation(System.out);

			tester.testGetAnnotation(System.out);

			Class c = AnnotationTester.class;
			AnnotatedElement element = c.getMethod("calculateInterest", float.class, float.class);
			tester.printAnnotations(element, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}