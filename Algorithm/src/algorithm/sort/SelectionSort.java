package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 *  定义： 
 *  算法复杂度： O(n^2)
 *  稳定排序： 否
 * @author wangyao
 *
 */
public class SelectionSort {

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void sort(int[] data) {
        sort(data, 0, data.length);
    }

    /**
     * 选择排序
     * 
     * @param data 要排序的数组
     * @param fromIndex 排序的第一个元素的索引（包括）
     * @param toIndex 要排序的最后一个元素的索引（不包括）
     */
    public static void sort(int[] data, int fromIndex, int toIndex) {
        /*
         * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。以此类推，直到所有元素均排序完毕。
         */
        int i, j, minIndex;

        for (i = fromIndex; i < toIndex - 1; i++) {
            minIndex = i;

            for (j = i + 1; j < toIndex; j++) {
                if (data[minIndex] > data[j])
                    minIndex = j;
            }

            swap(data, i, minIndex);
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
