package LeetCode.second_0628;
/*
213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2:

输入: [1,2,3,1]
输出: 4
解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
 */
public class Medium_213 {
    public int rob(int[] nums) {
        // dp[i] = x 当前下标至末尾能获得的最大价值为x
        // 有三种情况
        // 1.第一家和最后一家都不偷
        // 2.偷第一家不偷最后一家
        // 3.不偷第一家偷最后一家
        // 其实只要考虑2与3即可
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(
                dp(nums, 1, nums.length - 1),
                dp(nums, 0, nums.length - 2)
        );
    }

    public int dp(int[] nums, int start, int end) {
        int dp = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = end; i >= start; i--) {
            dp = Math.max(dp1, dp2 + nums[i]);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1,2,3
        };
        System.out.println(new Medium_213().rob(nums));

    }
}
