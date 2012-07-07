package sn.base.util;

import java.security.SecureRandom;
import java.util.Arrays;

public class RandomUtil {

    /**
     * 生成随机数字字串
     * 
     * @param length 字串长度
     * @return
     */
    public static String generatorNumber(int length) {
        return generatorNumbers(length, 1)[0];
    }

    /**
     * 生成多个随机数字字串
     * 
     * @param length 字串长度
     * @param amount 随机字串数量
     * @return
     */
    public static String[] generatorNumbers(int length, int amount) {
        if (length < 1 || amount < 1) {
            return null;
        }

        String[] numbers = new String[amount];
        StringBuffer sb = new StringBuffer(length);
        SecureRandom random = new SecureRandom();

        for (int n = 0; n < amount; n++) {
            for (int i = 0; i < length; i++) {
                sb.append(random.nextInt(10));
            }

            numbers[n] = sb.toString();
            sb.delete(0, length);
        }

        return numbers;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(generatorNumber(18));// 生成一个18位的数字字串
        System.out.println("------------------------------------");

        long begin = System.currentTimeMillis();
        String[] numbers = generatorNumbers(18, 1000);// 生成1000个18位的数字字串
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
        System.out.println(Arrays.toString(numbers));
    }
}
