package demo.java.lang.inheritance.child;

import demo.java.lang.inheritance.parent.Parent;

public class Child extends Parent {
    public String cPublic;
    protected String cProtected;
    String cPackage;
    private String cPrivate;

    // 静态初始化：首次加载类时执行
    static {
        System.out.println("Child class init");
    }

    // 动态初始化：创建类时执行
    {
        System.out.println("Child object init");
    }

    public Child() {
        this.cPublic = "cPublic";
        this.cProtected = "cProtected";
        this.cPackage = "cPackage";
        this.cPrivate = "cPrivate";
        System.out.println("Create Child()");
    }

    public Child(String pPublic, String pProtected, String pPackage, String pPrivate, String cPublic, String cProtected, String cPackage,
            String cPrivate) {
        super(pPublic, pProtected, pPackage, pPrivate);
        this.cPublic = cPublic;
        this.cProtected = cProtected;
        this.cPackage = cPackage;
        this.cPrivate = cPrivate;
        System.out
                .println("Create Child(String pPublic, String pProtected, String pPackage, String pPrivate, String cPublic, String cProtected, String cPackage, String cPrivate)");
    }

    public String toString() {
        return "Child(" + pPublic + "," + pProtected + "," + cPublic + "," + cProtected + "," + cPackage + "," + cPrivate + ")";
    }
}
