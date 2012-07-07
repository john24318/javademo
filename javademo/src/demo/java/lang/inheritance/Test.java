package demo.java.lang.inheritance;

import demo.java.lang.inheritance.child.Child;
import demo.java.lang.inheritance.grandson.Grandson;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 类的初始化次序：
        // 1.静态初始化：父类的静态变量或静态代码块 -> 子类的静态变量或静态代码块（注：首次加载时执行）
        // 2.父类的成员变量或代码块初始化 -> 父类的构造方法 -> 子类的成员变量或代码块初始化 -> 子类的构造方法
        Child child = new Child();

        System.out.println();

        // public、protected修饰的变量或方法在其子孙类中均可见
        System.out.println(child.toString());

        System.out.println();

        Grandson grandson = new Grandson();

        System.out.println();

        System.out.println(grandson.toString());

        System.out.println();

        Grandson grandson2 = new Grandson("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");

        System.out.println();

        System.out.println(grandson2.toString());
    }

}