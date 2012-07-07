package demo.java.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

    public static void test() {
        // 加入Set容器中的对象都必须重新定义equals()方法
        // 加入HashSet容器的对象还必须重新定义hashCode()方法
        Set<String> set = new HashSet<String>();

        set.add("caterpillar");
        set.add("justin");
        set.add("momor");
        set.add("justin"); // 重复加入justin

        // 迭代顺序与加入顺序不同，若要一致可使用LinkedHashSet
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        test();
    }

}
