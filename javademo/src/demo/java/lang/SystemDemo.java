package demo.java.lang;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SystemDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Current Tims:" + System.currentTimeMillis());

		System.getProperties().list(System.out);

		System.out.println("********************env*********************");
		Map<String, String> env = System.getenv();
		Set<Entry<String, String>> entrySet = env.entrySet();
		for (Entry<String, String> element : entrySet) {
			System.out.println(element.toString());
		}
	}

}
