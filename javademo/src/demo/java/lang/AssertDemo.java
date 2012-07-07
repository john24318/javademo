package demo.java.lang;

public class AssertDemo {

    // 检查断言是否开启，使用java命令选项-ea或-enableassertions开启断言
    static {
        boolean assertsEnabled = false;

        // here's the trick
        assert assertsEnabled = true;

        if (!assertsEnabled)
            throw new RuntimeException("Asserts must be enabled!");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Start!");

        try {
            int i = 2;
            // assert i != 2;
            assert i != 2 : "i不等于2！";
        } catch (AssertionError e) {
            // 捕获AssertionError错误，若不捕获，则导致程序终止
            e.printStackTrace(System.out);
        }

        System.out.println("End!");
    }

}
