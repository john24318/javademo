package algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] data) {
        sort(data, 0, data.length);
    }

    /**
     * 快速排序
     * 
     * @param data 要排序的数组
     * @param fromIndex 排序的第一个元素的索引（包括）
     * @param toIndex 要排序的最后一个元素的索引（不包括）
     */
    public static void sort(int[] data, int fromIndex, int toIndex) {
        if (!(fromIndex < toIndex - 1))
            return;

        int temp, pivotpos = fromIndex;

        for (int i = fromIndex + 1; i < toIndex; i++) {
            if (data[i] < data[pivotpos]) {
                temp = data[i];

                for (int k = i; k > pivotpos; k--) {
                    data[k] = data[k - 1];
                }

                data[pivotpos] = temp;
                pivotpos++;
            }
        }

        sort(data, fromIndex, pivotpos);
        sort(data, pivotpos + 1, toIndex);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] data = { 1, 5, 4, 3, 2, 1 };
        // Arrays.sort(data, 1, 3);
        // sort(data, 1, 3);
        sort(data);
        System.out.println(Arrays.toString(data));
    }

}
