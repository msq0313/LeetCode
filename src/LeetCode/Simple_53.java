package LeetCode;
/*
53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

 */
public class Simple_53 {
//    public int maxSubArray(int[] nums) {
//        int len = nums.length;
//        if (len == 0) {
//            return 0;
//        }
//        int max = nums[0];
//        int sum = 0;
//        for (int num : nums) {
//            if (sum < 0) {
//                sum = num;
//            } else {
//                sum += num;
//            }
//            max = Math.max(max, sum);
//        }
//        return max;
//    }

    //动态规划
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int[] dp = new int[nums.length];
        //dp[i]代表以i为结尾的最大子序和
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Simple_53().maxSubArray(nums));
    }
}
