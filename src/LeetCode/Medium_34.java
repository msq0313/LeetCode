package LeetCode;

import java.util.Arrays;

public class Medium_34 {
//    二分搜索
//    在排序数组中查找元素的第一个和最后一个位置
//    输入: nums = [5,7,7,8,8,10], target = 8
//    输出: [3,4]
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int[] positon = new int[2];
        positon[0] = searchLowerBound(nums, target, low, high);
        positon[1] = searchHigherBound(nums, target, low, high);
        return positon;
    }

    int searchLowerBound(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target && (middle == 0 || nums[middle - 1] < target)) {
                return middle;
            }
            if (target <= nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    int searchHigherBound(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target && (middle == nums.length - 1 || nums[middle + 1] > target)) {
                return middle;
            }
            if (target < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Medium_34 medium_34 = new Medium_34();
        System.out.println(Arrays.toString(medium_34.searchRange(new int[]{2,2}, 2)));
    }
}
