package demo.java.lang;

public class ThreadLocalDemo {

    // 该类提供了线程局部变量，每个线程都有自己的局部变量
    private static final ThreadLocal<String> th = new ThreadLocal<String>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        th.set("main");// 主线程存入main字串
        System.out.println("Main Thread:" + th.get());

        new Thread("Thread 1") {
            public void run() {
                th.set("t1");// 线程1存入t1字串
                System.out.println(getName() + ":" + th.get());
            }
        }.start();

        new Thread("Thread 2") {
            public void run() {
                th.set("t2");// 线程2存入t2字串
                System.out.println(getName() + ":" + th.get());
            }
        }.start();

        System.out.println("Main Thread:" + th.get());
    }

}
