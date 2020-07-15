package LeetCode.second_0628;

import java.util.Arrays;

/*
面试题 16.16. 部分排序
给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。

示例：

输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
输出： [3,9]
提示：

0 <= len(array) <= 1000000
 */
public class Interview_16_16 {
    public int[] subSort(int[] array) {
        // 从前往后找到最后一个比前面最大值还小的数
        // 从后往前找到第一个比后面最小值还大的数
        int len = array.length;
        int start = -1;
        int end = -1;
        if (array.length == 0 || array.length == 1) {
            return new int[]{start, end};
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < max) {
                end = i;
            } else {
                max = array[i];
            }
            if (array[len - i - 1] > min) {
                start = len - i - 1;
            } else {
                min = array[len - i - 1];
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
//        int[] array = new int[]{
//                1,2,4,7,10,11,7,12,6,7,16,18,19
//        };
        int[] array = new int[]{
                1,3,9,7,5
        };
        System.out.println(Arrays.toString(new Interview_16_16().subSort(array)));
    }
}
