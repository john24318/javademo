package demo.java.lang.inheritance.parent;

import demo.java.lang.inheritance.Message;

public class Parent {
    static Message pStaticMessage = new Message("Parent static");
    Message pMessage = new Message("Parent");

    public String pPublic;
    protected String pProtected;
    String pPackage;
    private String pPrivate;

    public Parent() {
        this.pPublic = "pPublic";
        this.pProtected = "pProtected";
        this.pPackage = "pPackage";
        this.pPrivate = "pPrivate";
        System.out.println("Create Parent()");
    }

    public Parent(String pPublic, String pProtected, String pPackage, String pPrivate) {
        this.pPublic = pPublic;
        this.pProtected = pProtected;
        this.pPackage = pPackage;
        this.pPrivate = pPrivate;
        System.out.println("Create Parent(String pPublic, String pProtected, String pPackage, String pPrivate)");
    }

    public String toString() {
        return "Parent(" + pPublic + "," + pProtected + "," + pPackage + "," + pPrivate + ")";
    }

    // 静态初始化：首次加载类时执行
    static {
        System.out.println("Parent class init");
    }

    // 动态初始化：创建类时执行
    {
        System.out.println("Parent object init");
    }
}
