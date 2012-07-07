package com.younger.base.util;

import java.io.IOException;
import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 字符串工具类
 * 
 * @author wangyao
 * 
 */
public class StringUtil {

    private static final Log log = LogFactory.getLog(StringUtil.class);

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
     * 使用指定的加密算法对密码进行加密
     * 
     * @param password 待加密的密码
     * @param algorithm 加密算法（MD5生成长为16的字节数组，SHA生成长为20的字节数组）
     */
    public static String encodePassword(String password, String algorithm) {
        byte[] unencodedPassword = password.getBytes();
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception e) {
            log.error("获取算法为" + algorithm + "的MessageDigest实例失败！");
            log.error(e.getMessage());
            return password;
        }

        md.reset(); // 复位
        md.update(unencodedPassword); // 添加要进行计算摘要的信息
        byte[] encodedPassword = md.digest();// 计算出摘要

        return byteToHexString(encodedPassword);
    }

    /**
     * 对字符串使用Base64加密，当把密码存放到cookies时使用。
     * 
     * @param str
     * @return
     */
    public static String encodeString(String str) {
        sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        return encoder.encodeBuffer(str.getBytes()).trim();
    }

    /**
     * 对使用Base64加密的字符串解密
     * 
     * @param str
     * @return String
     */
    public static String decodeString(String str) {
        sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
        try {
            return new String(dec.decodeBuffer(str));
        } catch (IOException io) {
            throw new RuntimeException(io.getMessage(), io.getCause());
        }
    }

    public static void main(String[] arsgs) {
        String ps = encodePassword("123456", "SHA");
        System.out.println(ps.length() + " : " + ps);
    }
}
