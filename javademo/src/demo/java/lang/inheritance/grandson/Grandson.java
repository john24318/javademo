package demo.java.lang.inheritance.grandson;

import demo.java.lang.inheritance.child.Child;

public class Grandson extends Child {
    public String gPublic;
    protected String gProtected;
    String gPackage;
    private String gPrivate;

    // 静态初始化：首次加载类时执行
    static {
        System.out.println("Grandson class init");
    }

    // 动态初始化：创建类时执行
    {
        System.out.println("Grandson object init");
    }

    public Grandson() {
        this.gPublic = "gPublic";
        this.gProtected = "gProtected";
        this.gPackage = "gPackage";
        this.gPrivate = "gPrivate";
        System.out.println("Create Grandson()");
    }

    public Grandson(String pPublic, String pProtected, String pPackage, String pPrivate, String cPublic, String cProtected, String cPackage,
            String cPrivate, String gPublic, String gProtected, String gPackage, String gPrivate) {
        super(pPublic, pProtected, pPackage, pPrivate, cPublic, cProtected, cPackage, cPrivate);
        this.gPublic = gPublic;
        this.gProtected = gProtected;
        this.gPackage = gPackage;
        this.gPrivate = gPrivate;
        System.out
                .println("Create Grandson(String pPublic, String pProtected, String pPackage, String pPrivate, String cPublic, String cProtected, String cPackage, String cPrivate, String gPublic, String gProtected, String gPackage, String gPrivate)");
    }

    public String toString() {
        return "Grandson(" + pPublic + "," + pProtected + "," + cPublic + "," + cProtected + "," + gPublic + "," + gProtected + ","
                + gPackage + "," + gPrivate + ")";
    }
}