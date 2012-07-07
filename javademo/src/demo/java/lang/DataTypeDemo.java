package demo.java.lang;

public class DataTypeDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Short占用2字节
        System.out.printf("short range: %d ~ %d\n", Short.MAX_VALUE, Short.MIN_VALUE);
        // Integer占用4字节
        System.out.printf("int range: %d ~ %d\n", Integer.MAX_VALUE, Integer.MIN_VALUE);
        // Long占用8字节
        System.out.printf("long range: %d ~ %d\n", Long.MAX_VALUE, Long.MIN_VALUE);
        // Byte占用1字节
        System.out.printf("byte range: %d ~ %d\n", Byte.MAX_VALUE, Byte.MIN_VALUE);
        // Float占用4字节
        System.out.printf("float range: %e ~ %e\n", Float.MAX_VALUE, Float.MIN_VALUE);
        // Double占用8字节
        System.out.printf("double range: %e ~ %e\n", Double.MAX_VALUE, Double.MIN_VALUE);
    }
}
