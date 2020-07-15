package Sort_Algorithm;

import com.sun.scenario.effect.Brightpass;

import java.util.Arrays;

/*
912. 排序数组
给你一个整数数组 nums，请你将该数组升序排列。

示例 1：

输入：nums = [5,2,3,1]
输出：[1,2,3,5]
示例 2：

输入：nums = [5,1,1,2,0,0]
输出：[0,0,1,1,2,5]

提示：

1 <= nums.length <= 50000
-50000 <= nums[i] <= 50000
 */
public class Medium_912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums,int left, int right) {
        if (nums == null || left < 0) return;
        if (left < right) {
            int dp = partition(nums, left, right);
            quickSort(nums, left, dp - 1);
            quickSort(nums, dp + 1, right);
        }
    }

    public int partition(int[] nums,int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right];
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                nums[right--] = nums[left];
            }
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,1};
        System.out.println(Arrays.toString(new Medium_912().sortArray(nums)));
    }
}
