package demo.java.io;

import java.io.IOException;
import java.io.PushbackInputStream;

public class PushbackInputStreamDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PushbackInputStream pushbackInputStream = new PushbackInputStream(System.in);
        byte[] array = new byte[2];
        int tmp = 0;

        try {
            while (-1 != pushbackInputStream.read(array)) {
                // 两个byte数组转换为short
                tmp = (short) ((array[0] << 8) | (array[1] & 0xff));
                tmp = tmp & 0xFFFF;

                // 判断是否为BIG5，若是则显示
                if (tmp >= 0xA440 && tmp < 0xFFFF) {
                    System.out.println("BIG5: " + new String(array));
                } else {
                    // 将数组中的第二个byte推回到流中
                    pushbackInputStream.unread(array, 1, 1);
                    // 显示ASCII范围的字符
                    System.out.println("ASCII: " + (char) array[0]);
                }
            }

            pushbackInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
