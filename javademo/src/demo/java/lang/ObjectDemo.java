package demo.java.lang;

import java.util.ArrayList;
import java.util.List;

public class ObjectDemo implements Cloneable {
    private String var1;
    private int var2;
    private boolean var3;
    private List<Object> var4;

    public ObjectDemo(String var1, int var2, boolean var3, int size) {
        super();
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = new ArrayList<Object>(size);
    }

    /**
     * 返回该对象的字符串表示
     */
    public String toString() {
        return super.toString() + "[var1=" + var1 + ", var2=" + var2 + ", var3=" + var3 + ", var4=" + var4
                + "]";
    }

    /**
     * 返回该对象的哈希码值。支持此方法是为了提高哈希表（例如 java.util.Hashtable 提供的哈希表）的性能
     * hashCode 的常规协定是：
     *      在 Java 应用程序执行期间，在对同一对象多次调用 hashCode 方法时，必须一致地返回相同的整数，前提是将对象进行 equals 比较时所用的信息没有被修改。
     *      如果根据 equals(Object) 方法，两个对象相等，那么对这两个对象中的每个对象调用 hashCode 方法都必须生成相同的整数结果。
     *      如果根据 equals(Object) 方法，两个对象不相等，那么对这两个对象中的任一对象上调用 hashCode 方法不 要求一定生成不同的整数结果。
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((var1 == null) ? 0 : var1.hashCode());
        result = prime * result + var2;
        result = prime * result + (var3 ? 1231 : 1237);
        result = prime * result + ((var4 == null) ? 0 : var4.hashCode());
        return result;
    }

    /**
     * 指示其他某个对象是否与此对象相等
     * equals 方法在非空对象引用上实现相等关系：
     *      自反性：对于任何非空引用值x，x.equals(x)==true。
     *      对称性：对于任何非空引用值x和y，当且仅当y.equals(x)==true时，x.equals(y)==true。
     *      传递性：对于任何非空引用值x、y和z，如果x.equals(y)==true，并且y.equals(z)==true，那么x.equals(z)==true。
     *      一致性：对于任何非空引用值x和y，多次调用x.equals(y)始终返回true或始终返回false，前提是对象上equals比较中所用的信息没有被修改。
     *      对于任何非空引用值x，x.equals(null)==false。
     * 注意：当此方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        final ObjectDemo other = (ObjectDemo) obj;
        if (var1 != null ? !var1.equals(other.var1) : other.var1 != null) {
            return false;
        }

        if (var2 != other.var2)
            return false;

        if (var3 != other.var3)
            return false;

        return true;
    }

    /**
     * 创建并返回此对象的一个副本
     */
    @SuppressWarnings("unchecked")
    public Object clone() throws CloneNotSupportedException {
        ObjectDemo newObjectDemo = (ObjectDemo) super.clone();
        if (this.var4 != null)
            newObjectDemo.var4 = (List<Object>) ((ArrayList<Object>) this.var4).clone();

        return newObjectDemo;
    }

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo("aaa", 111, true, 10);
        ObjectDemo other = new ObjectDemo("aaa", 111, true, 10);
        System.out.println(obj);
        System.out.println(other);
        System.out.println("obj.hashCode : " + obj.hashCode());
        System.out.println("other.hashCode : " + other.hashCode());
        System.out.println("obj.hashCode toHexString : " + Integer.toHexString(obj.hashCode()));
        System.out.println("obj.equals(other) : " + obj.equals(other));

        try {
            ObjectDemo clone = (ObjectDemo) obj.clone();
            obj.var1 = "bbb";
            System.out.println(clone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
