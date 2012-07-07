package demo.java.lang.loop;

public class ForDemo {

    public static boolean print(char c) {
        System.out.print(c);
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 输出:ABDCBDCB
        int i = 0;
        for (print('A'); print('B') && (i < 2); print('C')) {
            i++;
            print('D');
        }
    }
}
