package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *  定义： 通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 *  算法复杂度： O(n^2)
 *  稳定排序： 是
 * 
 * @author wangyao
 * 
 */
public class InsertSort {

    public static void sort(int[] data) {
        sort(data, 0, data.length);
    }

    /**
     * 插入排序
     * 
     * @param data 要排序的数组
     * @param fromIndex 排序的第一个元素的索引（包括）
     * @param toIndex 要排序的最后一个元素的索引（不包括）
     */
    public static void sort(int[] data, int fromIndex, int toIndex) {
        /*
         * 1. 从第一个元素开始，该元素可以认为已经被排序
         * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
         * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
         * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
         * 5. 将新元素插入到该位置中
         * 6. 重复步骤2
         */
        int i, j, temp;

        for (i = fromIndex + 1; i < toIndex; i++) {
            temp = data[i];

            for (j = i; (j > fromIndex) && (temp < data[j - 1]); j--) {
                data[j] = data[j - 1];
            }

            data[j] = temp;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] data = { 5, 4, 3, 2, 1 };
        // Arrays.sort(data, 1, 3);
        //sort(data, 1, 3);
        sort(data);
        System.out.println(Arrays.toString(data));

    }

}
