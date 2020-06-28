package LeetCode.second_0628;
/*
209. 长度最小的子数组
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

 */
public class Medium_209 {
    //双指针
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static void main(String[] args) {
//        int[] nums = new int[]{
//                2,3,1,2,4,3
//        };
//        int s = 7;

//        int[] nums = new int[]{
//                2,3,1
//        };
//        int s = 7;

        int[] nums = new int[]{
                10,5,13,4,8,4,5,11,14,9,16,10,20,8
        };
        int s = 80;

        System.out.println(new Medium_209().minSubArrayLen(s, nums));
    }
}
