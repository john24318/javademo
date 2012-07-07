package demo.java.lang;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import demo.java.security.MessageDigestDemo;

public class StringDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "中文123aBc中文！";

        System.out.println("str:" + str);
        System.out.println("str length:" + str.length());
        System.out.println("str toUpperCase:" + str.toUpperCase());
        System.out.println("str toLowerCase:" + str.toLowerCase());
        System.out.println("str charAt 1:" + str.charAt(1));
        System.out.println("str indexOf 文:" + str.indexOf('文'));
        System.out.println("str indexOf 123:" + str.indexOf("123"));
        System.out.println("str lastIndexOf 文:" + str.lastIndexOf('文'));
        System.out.println("str lastIndexOf 中文:" + str.lastIndexOf("中文"));
        System.out.println("str substring 2:" + str.substring(2));
        System.out.println("str substring 2, 8:" + str.substring(2, 8));
        System.out.println("str toCharArray:" + Arrays.toString(str.toCharArray()));
        System.out.println("str getBytes:" + Arrays.toString(str.getBytes()));
        System.out.println("str getBytes length:" + str.getBytes().length);

        String str1 = "fly";
        String str2 = "weight";
        String str3 = "flyweight";
        String str4;

        str4 = str1 + str2;
        System.out.println(str3 == str4);

        str4 = (str1 + str2).intern();
        System.out.println(str3 == str4);

        String sss = (String) null;
        System.out.println(sss);

        try {
            String chinese = "中文";
            byte[] bytes;

            bytes = chinese.getBytes();
            System.out.println("\ngetBytes()\t\t" + MessageDigestDemo.byteToHexString(bytes));
            System.out.println(new String(bytes, "GBK"));
            System.out.println(new String(bytes, "GB2312"));
            System.out.println(new String(bytes, "UTF-8"));
            System.out.println(new String(bytes, "ISO-8859-1"));

            bytes = chinese.getBytes("GBK");
            System.out.println("\ngetBytes(\"GBK\")\t\t" + MessageDigestDemo.byteToHexString(bytes));
            System.out.println(new String(bytes, "GBK"));
            System.out.println(new String(bytes, "GB2312"));
            System.out.println(new String(bytes, "UTF-8"));
            System.out.println(new String(bytes, "ISO-8859-1"));

            bytes = chinese.getBytes("GB2312");
            System.out.println("\ngetBytes(\"GB2312\")\t\t" + MessageDigestDemo.byteToHexString(bytes));
            System.out.println(new String(bytes, "GBK"));
            System.out.println(new String(bytes, "GB2312"));
            System.out.println(new String(bytes, "UTF-8"));
            System.out.println(new String(bytes, "ISO-8859-1"));

            bytes = chinese.getBytes("UTF-8");
            System.out.println("\ngetBytes(\"UTF-8\")\t\t" + MessageDigestDemo.byteToHexString(bytes));
            System.out.println(new String(bytes, "GBK"));
            System.out.println(new String(bytes, "GB2312"));
            System.out.println(new String(bytes, "UTF-8"));
            System.out.println(new String(bytes, "ISO-8859-1"));

            bytes = chinese.getBytes("ISO-8859-1");
            System.out.println("\ngetBytes(\"ISO-8859-1\")\t\t" + MessageDigestDemo.byteToHexString(bytes));
            System.out.println(new String(bytes, "GBK"));
            System.out.println(new String(bytes, "GB2312"));
            System.out.println(new String(bytes, "UTF-8"));
            System.out.println(new String(bytes, "ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
