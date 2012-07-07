package demo.java.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ArrayListDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        
        list.add("A");
        list.add("A");
        list.add("A");
        list.add("B");
        list.add("C");
        for(String s : list) {
            System.out.println(s);
        }
        list.remove("A");
        for(String s : list) {
            System.out.println(s);
        }

        System.out.println("输入quit结束");
        while (true) {
            System.out.print("# ");
            String input = scanner.next();

            if (input.equals("quit"))
                break;
            list.add(input);
        }

        System.out.print("显示输入1: ");
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");

        System.out.print("\n显示输入2: ");
        for (Iterator<String> it = list.iterator(); it.hasNext();) {
            System.out.print(it.next() + " ");
        }

        System.out.print("\n显示输入3: ");
        for (String str : list) {
            System.out.print(str + " ");
        }
    }

}
