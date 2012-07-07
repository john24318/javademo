package demo.java.util;

import java.util.Arrays;
import java.util.Random;

public class RandomDemo {

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
        Random random = new Random();

        for (int n = 0; n < amount; n++) {
            for (int i = 0; i < length; i++) {
                random.setSeed(System.nanoTime());
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
        long seed = 10000;
        int max = 1000;
        Random random = new Random();

        System.out.println(random.nextInt());
        System.out.println("------------------------------------");

        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println("------------------------------------");

        /**
         * 种子相同，产生的随机数序列相同
         */
        random.setSeed(seed); // 指定种子
        System.out.println(random.nextInt(max));// 返回一个伪随机数，在 [0, n)之间均匀分布的int值
        System.out.println(random.nextInt(max));
        System.out.println("************************************");

        random.setSeed(seed); // 指定种子
        System.out.println(random.nextInt(max));
        System.out.println(random.nextInt(max));
        System.out.println("************************************");

        random = new Random(seed);// 指定种子
        System.out.println(random.nextInt(max));
        System.out.println(random.nextInt(max));
        System.out.println("------------------------------------");

        System.out.println(generatorNumber(18));// 生成一个指定位数的数字字串
        System.out.println("------------------------------------");

        long begin = System.currentTimeMillis();
        String[] numbers = generatorNumbers(18, 1000);
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
        System.out.println(Arrays.toString(numbers));
    }

}
