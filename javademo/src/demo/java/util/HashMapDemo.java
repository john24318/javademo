package demo.java.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void test() {
        Map<String, String> map = new HashMap<String, String>();

        map.put("caterpillar", "caterpillar's message!!");
        map.put("justin", "justin's message!!");

        System.out.println(map.get("justin"));
        System.out.println(map.get("caterpillar"));
        System.out.println();

        Collection<String> collection = map.values();
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        test();
    }

}
