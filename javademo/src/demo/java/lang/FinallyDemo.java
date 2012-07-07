package demo.java.lang;

public class FinallyDemo {

    public static int finallyTest() {
        int ret = 1;
        System.out.println("1 : " + ret);

        try {
            ret = 2;
            System.out.println("2 : " + ret);

            ret = 1 / 0;
            System.out.println("3 : " + ret);

            return ret; // 此处return返回值为2
        } catch (Exception e) {
            ret = 3;
            System.out.println("4 : " + ret);

            return ret;// 此处return返回值为3
        } finally {
            ret = 4;
            System.out.println("5 : " + ret);

            // return ret; //此处return返回值为4
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(finallyTest());
    }

}
