package demo.math;

import java.util.Arrays;

import org.apache.commons.math.random.RandomData;
import org.apache.commons.math.random.RandomDataImpl;

public class RandomDataDemo {

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
        RandomData random = new RandomDataImpl();

        for (int n = 0; n < amount; n++) {
            for (int i = 0; i < length; i++) {
                sb.append(random.nextSecureInt(0, 9));
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
        int max = 1000;
        RandomData random = new RandomDataImpl();

        System.out.println(random.nextInt(0, max));
        System.out.println(random.nextSecureInt(0, max));
        System.out.println("------------------------------------");

        System.out.println(random.nextHexString(16));
        System.out.println(random.nextSecureHexString(16));
        System.out.println("------------------------------------");

        System.out.println(random.nextExponential(1));
        System.out.println("------------------------------------");

        System.out.println(random.nextGaussian(1, 1));
        System.out.println("------------------------------------");

        System.out.println(random.nextPoisson(1));
        System.out.println("------------------------------------");

        System.out.println(random.nextUniform(1, 2));
        System.out.println("------------------------------------");

        int[] ints = new int[20];
        ints = random.nextPermutation(max, ints.length);
        System.out.println(Arrays.toString(ints));
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
