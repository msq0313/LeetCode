package Examination.Baidu.Interview.q2;
/*
调整数组数字使奇数在前偶数在后
 */

import java.util.Arrays;

public class Main {
    public int[] mySort(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 < nums[j] % 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            if (nums[i] % 2 == 1) i++;
            if (nums[j] % 2 == 0) j--;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(new Main().mySort(nums)));

    }
}