package demo.java.security;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class KeyGeneratorDemo {

    /**
     * @param args
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static void main(String[] args) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("AES"); // 获取密匙生成器
        kg.init(128); // 初始化；DES算法必须是56位，DESede算法可以是112位或168位，AES算法可以是128、192、256位
        SecretKey key = kg.generateKey(); // 生成密匙，可用多种方法来保存密匙

        Cipher cp = Cipher.getInstance("AES"); // 创建密码器

        // 加密：
        cp.init(Cipher.ENCRYPT_MODE, key); // 初始化
        String str = "egotom.com啊ha";
        byte[] ptext = str.getBytes("UTF8");
        byte[] ctext = cp.doFinal(ptext); // 加密
        System.out.println(ptext.length + ";" + ctext.length);

        // 解密：
        cp.init(Cipher.DECRYPT_MODE, key); // 初始化
        byte[] dtext = cp.doFinal(ctext); // 解密

        String decStr = new String(dtext, "UTF8"); // 重新显示明文
        System.out.println(decStr);

        int number = 10; // 需生成的序列号个数
        for (int i = 0; i < number; i++) {
            key = kg.generateKey();
            cp.init(Cipher.ENCRYPT_MODE, key);
            ctext = cp.doFinal(ptext);
            System.out.println(MessageDigestDemo.byteToHexString(ctext).toUpperCase());
        }
    }
}
