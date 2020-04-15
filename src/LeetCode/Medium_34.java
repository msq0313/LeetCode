package LeetCode;

import java.util.Arrays;

public class Medium_34 {
/*
34.在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
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
