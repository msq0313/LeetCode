package Sword;
/*
剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

提示：

1 <= arr.length <= 10^5
-100 <= arr[i] <= 100
 */
public class Offer_42 {
//    public int maxSubArray(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int max = Integer.MIN_VALUE;
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            max = Math.max(max, sum);
//            if (sum < 0) {
//                sum = 0;
//            }
//        }
//        return max;
//    }

    // dp
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int[] dp = new int[nums.length];
        //dp[i]代表以i为结尾的最大子序和
        int max = nums[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    // 简化dp
//    public int maxSubArray(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int res = nums[0];
//        int max = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            max = Math.max(nums[i], max + nums[i]);
//            res = Math.max(res, max);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4};
        System.out.println(new Offer_42().maxSubArray(nums));
    }
}
