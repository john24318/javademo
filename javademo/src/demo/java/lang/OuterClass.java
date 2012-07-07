package demo.java.lang;

/**
 * Java内部类：静态成员内部类、成员内部类、局部内部类、静态局部内部类、匿名内部类
 * 
 * @author 王耀
 * 
 */
@SuppressWarnings("unused")
public class OuterClass {
    public static String PUBS = "public static";
    static String PACS = "package static";
    private static String PRIS = "private static";
    public String pubs = "public";
    String pacs = "package";
    private String pris = "private";

    public static void pubsm() {
        final String ls = "local";

        /**
         * <pre>
         * 静态局部内部类
         *      不能使用public、protected、private、static、final修饰
         *      只能定义成员变量、成员方法；不能定义static变量、static方法
         *      只能访问外部类的静态变量、静态方法、局部final变量；不能访问外部类的成员变量、成员方法
         * </pre>
         */
        class StaticLocalInnerClass {
            /* 静态局部内部类中不允许定义static变量、static方法 */
            public String ipubs = "inner public";
            String ipacs = "inner package";
            private String ipris = "inner private";

            public void ipubm() {
                /* 静态局部内部类只能访问外部类的静态变量、静态方法、局部final变量 */
                System.out.println(PUBS);
                System.out.println(PACS);
                System.out.println(PRIS);
                pubsm();
                pacsm();
                prism();
                // System.out.println(pubs);
                // System.out.println(pacs);
                // System.out.println(pris);
                // pubm();
                // pacm();
                // prim();
                System.out.println(ls);
                System.out.println("inner public method");
            }

            void ipacm() {
                System.out.println("inner package method");
            }

            private void iprim() {
                System.out.println("inner private method");
            }
        }

        System.out.println("public static method");
    }

    static void pacsm() {
        System.out.println("package static method");
    }

    private static void prism() {
        System.out.println("private static method");
    }

    public void pubm() {
        final String ls = "local";

        /**
         * <pre>
         * 局部内部类
         *      不能使用public、protected、private、static、final修饰
         *      只能定义成员变量、成员方法；不能定义static变量、static方法
         *      可以访问外部类的静态变量、静态方法、成员变量、成员方法、局部final变量
         * </pre>
         */
        class LocalInnerClass {
            /* 局部内部类中不允许定义static变量、static方法 */
            public String ipubs = "inner public";
            String ipacs = "inner package";
            private String ipris = "inner private";

            public void ipubm() {
                /* 局部内部类可以访问外部类的静态变量、静态方法、成员变量、成员方法、局部final变量 */
                System.out.println(PUBS);
                System.out.println(PACS);
                System.out.println(PRIS);
                pubsm();
                pacsm();
                prism();
                System.out.println(pubs);
                System.out.println(pacs);
                System.out.println(pris);
                pubm();
                pacm();
                prim();
                System.out.println(ls);
                System.out.println("inner public method");
            }

            void ipacm() {
                System.out.println("inner package method");
            }

            private void iprim() {
                System.out.println("inner private method");
            }
        }

        /**
         * <pre>
         * 匿名内部类
         *      不能使用public、protected、private、static、final修饰
         *      只能定义成员变量、成员方法；不能定义static变量、static方法
         *      可以访问外部类的静态变量、静态方法、成员变量、成员方法、局部final变量
         * </pre>
         */
        Object obj = new Object() {
            /* 匿名内部类中不允许定义static变量、static方法 */
            public String ipubs = "inner public";
            String ipacs = "inner package";
            private String ipris = "inner private";

            public void ipubm() {
                /* 匿名内部类可以访问外部类的静态变量、静态方法、成员变量、成员方法、局部final变量 */
                System.out.println(PUBS);
                System.out.println(PACS);
                System.out.println(PRIS);
                pubsm();
                pacsm();
                prism();
                System.out.println(pubs);
                System.out.println(pacs);
                System.out.println(pris);
                pubm();
                pacm();
                prim();
                System.out.println(ls);
                System.out.println("inner public method");
            }

            void ipacm() {
                System.out.println("inner package method");
            }

            private void iprim() {
                System.out.println("inner private method");
            }
        };

        System.out.println("public method");
    }

    void pacm() {
        System.out.println("package method");
    }

    private void prim() {
        System.out.println("private method");
    }

    /**
     * <pre>
     * 静态成员内部类
     *      可用public、protected、private、final修饰
     *      可以定义static量、static方法、成员变量、成员方法
     *      只能访问外部类的静态变量、静态方法，不能访问外部类的成员变量、成员方法
     * </pre>
     */
    public static class StaticInnerClass {
        public static String IPUBS = "inner public static";
        static String IPACS = "inner package static";
        private static String IPRIS = "inner private static";
        public String ipubs = "inner public";
        String ipacs = "inner package";
        private String ipris = "inner private";

        public static void ipubsm() {
            System.out.println("inner public static method");
        }

        static void ipacsm() {
            System.out.println("inner package static method");
        }

        private static void iprism() {
            System.out.println("inner private static method");
        }

        public void ipubm() {
            /* 静态成员内部类只能访问外部类的静态变量、静态方法 */
            System.out.println(PUBS);
            System.out.println(PACS);
            System.out.println(PRIS);
            pubsm();
            pacsm();
            prism();
            // System.out.println(pubs);
            // System.out.println(pacs);
            // System.out.println(pris);
            // pubm();
            // pacm();
            // prim();
            System.out.println("inner public method");
        }

        void ipacm() {
            System.out.println("inner package method");
        }

        private void iprim() {
            System.out.println("inner private method");
        }
    }

    /**
     * <pre>
     * 成员内部类
     *      可用public、protected、private、final修饰
     *      只能定义成员变量、成员方法；不能定义static变量、static方法
     *      可以访问外部类的静态变量、静态方法、成员变量、成员方法
     * </pre>
     */
    public class InnerClass {
        /* 成员内部类中不允许定义static变量、static方法 */
        public String ipubs = "inner public";
        String ipacs = "inner package";
        private String ipris = "inner private";

        public void ipubm() {
            /* 成员内部类可以访问外部类的静态变量、静态方法、成员变量、成员方法 */
            System.out.println(PUBS);
            System.out.println(PACS);
            System.out.println(PRIS);
            pubsm();
            pacsm();
            prism();
            System.out.println(pubs);
            System.out.println(pacs);
            System.out.println(pris);
            pubm();
            pacm();
            prim();
            System.out.println("inner public method");
        }

        void ipacm() {
            System.out.println("inner package method");
        }

        private void iprim() {
            System.out.println("inner private method");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}
