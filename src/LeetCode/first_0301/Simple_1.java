package LeetCode.first_0301;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1. 两数之和
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class Simple_1 {
    //暴力法
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
    //一遍哈希表，时间复杂度O(n)，空间复杂度O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int half = target - nums[i];
            if (map.containsKey(half)) {
                return new int[]{map.get(half),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 7, 11, 15
        };
        int target = 9;
        System.out.println(Arrays.toString(new Simple_1().twoSum(nums, target)));
    }
}
