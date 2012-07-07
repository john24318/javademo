package demo.java.util;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // toString返回指定数组内容的字符串表示形式
        // deepToString回指定数组“深层内容”的字符串表示形式。
        int[] arr = { 93, 5, 3, 55, 57, 7, 2, 73, 41, 91 };
        System.out.println("排序前: " + Arrays.toString(arr));

        // sort对指定数组按升序排序
        Arrays.sort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));

        // copyOf方法jdk1.6新增，复制指定的数组
        int[] arrCopy1 = Arrays.copyOf(arr, 11);
        System.out.println("arrCopy1" + Arrays.toString(arrCopy1));

        // copyOfRange方法jdk1.6新增，将指定数组的指定范围复制到一个新数组
        int[] arrCopy2 = Arrays.copyOfRange(arr, 1, 5);
        System.out.println("arrCopy2" + Arrays.toString(arrCopy2));

        // copyOfRange方法jdk1.6新增，将指定数组的指定范围复制到一个新数组
        int[] arrCopy3 = Arrays.copyOfRange(arr, 9, 11);
        System.out.println("arrCopy3" + Arrays.toString(arrCopy3));

        // System.arraycopy从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束
        int[] arrCopy4 = new int[10];
        System.arraycopy(arr, 1, arrCopy4, 0, 3);
        System.out.println("arrCopy3" + Arrays.toString(arrCopy4));

        // binarySearch使用二分搜索法来搜索数组
        int position = Arrays.binarySearch(arr, 5);
        System.out.println(position);
        position = Arrays.binarySearch(arr, 6);
        System.out.println(position);

        // asList返回一个受指定数组支持的固定大小的列表。
        List<int[]> list1 = Arrays.asList(arr, arrCopy1, arrCopy2);
        System.out.println(list1);
        List<String> list2 = Arrays.asList("Larry", "Moe", "Curly");
        System.out.println(list2);

        // fill将指定的值分配给数组的每个元素
        // equals如果两个指定数组彼此相等，则返回 true
        // deepEquals如果两个指定数组彼此是深层相等的，则返回 true
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int[] arr3 = new int[10];
        Arrays.fill(arr1, 5);
        Arrays.fill(arr2, 5);
        Arrays.fill(arr3, 10);
        System.out.println("arr1" + Arrays.toString(arr1));
        System.out.println("arr2" + Arrays.toString(arr2));
        System.out.println("arr3" + Arrays.toString(arr3));
        System.out.println("arr1 == arr2 : " + Arrays.equals(arr1, arr2));
        System.out.println("arr1 == arr3 : " + Arrays.equals(arr1, arr3));

    }
}
