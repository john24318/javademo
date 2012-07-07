package demo.snippets;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;

public class ConvertOutputStreamToInputStream {

    /**
     * 将InputStream打印
     * 
     * @param in
     */
    public static void printDate(InputStream in) {
        Reader isReader = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isReader);
        String str = null;
        try {
            while (null != (str = reader.readLine())) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                isReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * <pre>
     * 方法1：将ByteArrayOutputStream转换成InputStream
     *       此方法需要将输入数据全部缓存在内存中，如数据量较大，此方法不适用。
     * </pre>
     */
    public static void m1() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        try {
            // 模拟程序将数据写到OutputStream中
            out.write("Message\nhello!".getBytes());
            // 将ByteArrayOutputStream转换成ByteArrayInputStream
            in = new ByteArrayInputStream(out.toByteArray());
            // 打印输入流
            printDate(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * <pre>
     * 方法2：将PipedOutputStream转换成InputStream
     * </pre>
     */
    public static void m2() {
        try {
            final PipedOutputStream out = new PipedOutputStream();

            // 将PipedOutputStream转换成PipedInputStream
            // 必须先建立管道连接，否则不能写数据
            final PipedInputStream in = new PipedInputStream(out, 1024);

            // 模拟程序将数据写到OutputStream中
            new Thread(new Runnable() {
                public void run() {
                    try {
                        out.write("Message\nhello!".getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            // 打印输入流
            // printDate(in);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        byte[] buffer = new byte[1024];
                        int length = 0;
                        while (-1 != (length = in.read(buffer))) {
                            System.out.println(new String(buffer, 0, length));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            // out.close();
            // in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // m1();
        m2();
        // m3();
    }

}
