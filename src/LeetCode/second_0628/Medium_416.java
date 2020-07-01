package LeetCode.second_0628;

import java.util.Arrays;

/*
416. 分割等和子集
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
 
示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.

 */
public class Medium_416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        // 转化为背包问题，此时sum为背包装满时的重量
        sum /= 2;

//        // dp[i][j]表示前i个元素，对于容量为j的背包，可以恰好将其装满
//        boolean[][] dp = new boolean[n + 1][sum + 1];
//        // base case 容量为0时，代表可装满
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][0] = true;
//        }
        // n为物品个数，状态为前i个物品以及背包剩余容量
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= sum; j++) {
//                if (j - nums[i - 1] < 0) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    // 装入或不装入背包有一个满足即可
//                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
//                }
//            }
//        }
        // 状态压缩后
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] | dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 5
        };

        System.out.println(new Medium_416().canPartition(nums));
    }
}
