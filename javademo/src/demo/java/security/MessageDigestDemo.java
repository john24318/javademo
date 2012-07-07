package demo.java.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <pre>
 * 消息摘要
 *      一个消息摘要就是一个数据块的数字指纹。即对一个任意长度的一个数据块进行计算，产生一个唯一指印（MD5生成长为16的字节数组，SHA1生成长为20的字节数组）。
 * </pre>
 * 
 * @author wangyao
 * 
 */
public class MessageDigestDemo {

    public static final String MESSAGE_DIGEST_ALGORITHM_MD5 = "MD5";
    public static final String MESSAGE_DIGEST_ALGORITHM_SHA = "SHA";

    /**
     * 将byte数组转换为十六进制的字符串
     * 
     * @param array
     * @return
     */
    public static String byteToHexString(byte[] array) {
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 0xff) < 0x10) {
                buf.append("0");
            }
            buf.append(Integer.toHexString(array[i] & 0xff));
        }

        return buf.toString();
    }

    /**
     * 计算字符串消息摘要
     * 
     * @param password 待计算字符串
     * @param algorithm 加密算法
     * @return
     */
    public static String encodePassword(String password, String algorithm) {
        byte[] unencodedPassword = password.getBytes();
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return password;
        }

        md.reset(); // 复位
        md.update(unencodedPassword); // 添加要进行计算摘要的信息
        byte[] result = md.digest(); // 计算出摘要

        return byteToHexString(result);
    }

    /**
     * 计算文件消息摘要
     * 
     * @param filePath 文件路径
     * @param algorithm 加密算法
     * @return
     */
    public static String encodeFile(String filePath, String algorithm) {
        MessageDigest md = null;
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        byte[] buffer = new byte[1024]; // 自定义缓存
        int length = 0;

        try {
            fileInputStream = new FileInputStream(file);
            md = MessageDigest.getInstance(algorithm);
            md.reset(); // 复位

            while (-1 != (length = fileInputStream.read(buffer))) {
                md.update(buffer, 0, length); // 添加要进行计算摘要的信息
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (null != fileInputStream)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        byte[] result = md.digest(); // 计算出摘要
        return byteToHexString(result);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(encodePassword("123456", MESSAGE_DIGEST_ALGORITHM_MD5));
        System.out.println(encodePassword("123456", MESSAGE_DIGEST_ALGORITHM_SHA));
        System.out.println(encodeFile("src/demo/java/security/MessageDigestDemo.java", MESSAGE_DIGEST_ALGORITHM_MD5));
        System.out.println(encodeFile("src/demo/java/security/MessageDigestDemo.java", MESSAGE_DIGEST_ALGORITHM_SHA));
    }

}
