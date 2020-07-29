package Sort_Algorithm;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 冒泡排序是稳定排序，稳定排序：对于数组里两个相等的数，经过排序后，两个数的相对位置保持不变
     * 空间复杂度：O(1)
     * 假设数组的元素个数是n，整个排序过程中，直接在给定的数组里进行元素的两两交换
     * 时间复杂度：O(n^2)
     * 情景一：给定的数组按照顺序已经排好
     * 只需要进行n-1次比较，两两交换次数为0，时间复杂度O(n)，这是最好的情况
     * 情景二：给定的数组按照逆序排列
     * 需要进行n(n-1)/2次比较，时间复杂度是O(n^2),这是最坏的情况
     * 情景三：给定的数组杂乱无章
     * 在这种情况下，平均时间复杂度是O(n^2)
     */
    private int[] bubbleSort(int[] nums) {
        boolean hasChange = true;
        for (int i = 0; i < nums.length - 1 && hasChange; i++) {
            //若此轮未发生交换，则证明相邻两个数后一个数都比前一个数大，证明已排好序
            hasChange = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    hasChange = true;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();   //获取开始时间
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = new int[]{
                2,1,4,7,4,8,3,6,4,7
        };
        System.out.println(Arrays.toString(bubbleSort.bubbleSort(nums)));
        long endTime = System.nanoTime(); //获取结束时间
        System.out.println("程序运行时间： "+ (endTime-startTime) +"ns");
    }
}
