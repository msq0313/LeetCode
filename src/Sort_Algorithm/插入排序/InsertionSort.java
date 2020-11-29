package Sort_Algorithm.插入排序;

import java.util.Arrays;

public class InsertionSort {
    /**
     * 稳定
     * 空间复杂度：O(1)，也是两两交换
     * 时间复杂度：O(n^2)
     * 情景一：给定的数组按照顺序排好
     * 只需进行n-1次比较，两两交换次数为0，时间复杂度O(n)，这是最好的情况
     * 情景二：给定的数组按照逆序排列
     * 需要进行n(n-1)/2次比较，时间复杂度是O(n^2),这是最坏的情况。
     * 情景三：给定的数组杂乱无章
     * 在这种情况下，平均时间复杂度是O(n^2)
     * Leetcode147
     */
    private int[] insertionSort(int[] nums) {
        int current;
        for (int i = 1; i < nums.length; i++) {
            current = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > current) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = current;
        }
        return nums;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        int[] nums = new int[]{
                2,1,4,7,4,8,3,6,4,7
        };
        InsertionSort insertionSort = new InsertionSort();
        System.out.println(Arrays.toString(insertionSort.insertionSort(nums)));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+ (endTime-startTime) +"ns");
    }
}
