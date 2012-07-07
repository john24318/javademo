package demo.java.io;

import java.io.File;

public class FileDemo {

	public static void test() {
		System.out.println(new File("").getAbsolutePath());
		System.out.println(new File("/").getAbsolutePath());// or File("\\")

		System.out.println(FileDemo.class.getResource("").getPath());
		System.out.println(FileDemo.class.getResource("/").getPath());

		System.out.println(ClassLoader.getSystemResource("").getPath());
		// System.out.println(ClassLoader.getSystemResource("/").getPath());

		System.out.println("user.dir " + System.getProperty("user.dir"));
		System.out.println("user.home " + System.getProperty("user.home"));
		System.out.println("file.separator " + System.getProperty("file.separator"));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
	}

}
