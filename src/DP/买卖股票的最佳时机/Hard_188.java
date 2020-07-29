package DP.买卖股票的最佳时机;
/*
188. 买卖股票的最佳时机 IV
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [2,4,1], k = 2
输出: 2
解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2:

输入: [3,2,6,5,0,3], k = 2
输出: 7
解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 */
public class Hard_188 {
    public int maxProfit(int k, int[] prices) {
        // 此题能够任意指定交易次数
        // k <= len/2
        // 状态有三个：天数、交易数、是否持有股票 i从0开始，k从1开始
        // dp[i][k][0 or 1] 为在第i天，k次交易次数，是否持有股票时能获得的最大利润
        // 求dp[n - 1][K][0]即为在最后一天，k次交易次数，未持有股票时能获得的最大利润（已卖出）
        // 未持有股票的状态，通过前一天未持有保持，或者前一天持有且在今天卖了股票而得到
        // dp[i][k][0] = max(dp[i - 1][k][0],dp[i - 1][k][1] + prices[i]) 卖时获得利润
        // 持有股票状态，通过前一天持有保持，或者前一天未持有且在今天买了股票而得到
        // dp[i][k][1] = max(dp[i - 1][k][1],dp[i - 1][k - 1][0] - prices[i]) 买时减少利润

        // 大于len / 2时，与股票2问题一样，可以避免k过大时测试用例不通过的问题
        int len = prices.length;
        if (k > len / 2) {
            int res = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int K = k; K >= 1; K--) {
                if (i == 0) {
                    // base case
                    dp[i][K][0] = 0;
                    dp[i][K][1] = -prices[i];
                    continue;
                }
                dp[i][K][0] = Math.max(dp[i - 1][K][0],dp[i - 1][K][1] + prices[i]);
                dp[i][K][1] = Math.max(dp[i - 1][K][1],dp[i - 1][K - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{
                3,2,6,5,0,3
        };
        int k = 2;
        System.out.println(new Hard_188().maxProfit(k, prices));
    }
}
