package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *  定义： 重复地走访过要排序的数列，一次比较两个项目，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 *  算法复杂度： O(n^2)
 *  稳定排序： 是
 *  
 * @author wangyao
 *
 */
public class BubbleSort {
    
    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    
    public static void sort(int[] data) {
        sort(data, 0, data.length);
    }

    /**
     * 冒泡排序
     * 
     * @param data 要排序的数组
     * @param fromIndex 排序的第一个元素的索引（包括）
     * @param toIndex 要排序的最后一个元素的索引（不包括）
     */
    public static void sort(int[] data, int fromIndex, int toIndex) {
        /*
         * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
         * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
         * 3. 针对所有的元素重复以上的步骤，除了最后一个。
         * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
         */
        for (int i = fromIndex; i < toIndex - 1; i++) {
            for (int j = toIndex - 1; j > i; j--) {
                if (data[j] < data[j - 1]) {
                    swap(data, j , j-1);
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] data = { 5, 4, 3, 2, 1 };
        // Arrays.sort(data, 1, 3);
        // sort(data, 1, 3);
        sort(data);
        System.out.println(Arrays.toString(data));
    }

}
