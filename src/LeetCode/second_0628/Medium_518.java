package LeetCode.second_0628;
/*
518. 零钱兑换 II
给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 
示例 1:

输入: amount = 5, coins = [1, 2, 5]
输出: 4
解释: 有四种方式可以凑成总金额:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
示例 2:

输入: amount = 3, coins = [2]
输出: 0
解释: 只用面额2的硬币不能凑成总金额3。
示例 3:

输入: amount = 10, coins = [10]
输出: 1
 
注意:

你可以假设：

0 <= amount (总金额) <= 5000
1 <= coin (硬币面额) <= 5000
硬币种类不超过 500 种
结果符合 32 位符号整数

 */
public class Medium_518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
//        int[][] dp = new int[n + 1][amount + 1];
//        // dp[i][j]含义为，前i种硬币有几种凑成j金额的方法
//        // base case
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= amount; j++) {
//                if (j - coins[i - 1] >= 0) {
//                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
//                }
//                else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }
        //状态压缩为一维数组
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }

        return dp[amount];
    }
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{
                1, 2, 5
        };

        System.out.println(new Medium_518().change(amount, coins));
    }
}