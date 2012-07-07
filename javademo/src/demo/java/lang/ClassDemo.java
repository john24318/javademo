package demo.java.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ClassDemo {

    public static void info(Class<?> clazz) {
        System.out.println("Name : " + clazz.getName());
        System.out.println("Package : " + (null != clazz.getPackage() ? clazz.getPackage().getName() : null));
        System.out.println("isArray : " + clazz.isArray());
        System.out.println("isEnum : " + clazz.isEnum());
        System.out.println("isInterface : " + clazz.isInterface());
        System.out.println("isLocalClass : " + clazz.isLocalClass());
        System.out.println("isPrimitive : " + clazz.isPrimitive());
        System.out.println("superclass : "
                + (null != clazz.getSuperclass() ? clazz.getSuperclass().getName() : null));

        System.out.println("Interfaces : ");
        for (Class<?> c : clazz.getInterfaces()) {
            System.out.println("\t" + c.getName());
        }
    }

    public static void print(Class<?> c) {
        Package p = c.getPackage();
        System.out.printf("package %s;%n", p.getName());

        int m = c.getModifiers();
        System.out.print(Modifier.toString(m) + " ");
        if (Modifier.isInterface(m)) {
            System.out.print("interface ");
        } else {
            System.out.print("class ");
        }
        System.out.println(c.getName() + " {");

        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.print("\t" + Modifier.toString(field.getModifiers()));
            System.out.print(" " + field.getType().getName() + " ");
            System.out.println(field.getName() + ";");
        }

        Constructor<?>[] constructors = c.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.print("\t" + Modifier.toString(constructor.getModifiers()));
            System.out.println(" " + constructor.getName() + "();");
        }

        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("\t" + Modifier.toString(method.getModifiers()));
            System.out.print(" " + method.getReturnType().getName() + " ");
            System.out.println(method.getName() + "();");
        }
        System.out.println("}");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        info(ArrayList.class);
        System.out.println();

        info(ClassDemo.class);
        System.out.println();

        info(Integer.class);
        System.out.println();

        info(int.class);
        System.out.println();

        info(String.class);
        System.out.println();

        print(String.class);
    }

}
