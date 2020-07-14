package Sort_Algorithm;

import java.util.Arrays;

public class QuickSort3 {
    // 快速排序优雅版
    public int[] Sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        //对特殊值和边界值的检查，提高程序的鲁棒性
        if (nums == null || left < 0) {
            return;
        }
        if (left < right) {
            int dp = partition(nums, left, right);
            quickSort(nums, left, dp - 1);
            quickSort(nums, dp + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot)
                right--;
            if (left < right)
                nums[left++] = right;
            while (left < right && nums[left] <= pivot)
                left++;
            if (left < right)
                nums[right--] = left;
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 4, 7, 4, 8};
        System.out.println(Arrays.toString(new QuickSort3().Sort(nums)));
    }
}
