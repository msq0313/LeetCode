package LeetCode.买卖股票的最佳时机;
/*
123. 买卖股票的最佳时机 III
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0
解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Hard_123 {
//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        if (n == 0) {
//            return 0;
//        }
//        // 限制了两笔交易
//        int k = 2;
//        int[][][] dp = new int[n][k+1][2];
//        for (int i = 0; i < n; i++) {
//            for (int K = k; K >= 1; K--) {
//                if (i == 0) {
//                    dp[i][K][0] = 0;
//                    dp[i][K][1] = -prices[i];
//                    continue;
//                }
//                dp[i][K][0] = Math.max(dp[i - 1][K][0], dp[i - 1][K][1] + prices[i]);
//                dp[i][K][1] = Math.max(dp[i - 1][K][1], dp[i - 1][K - 1][0] - prices[i]);
//            }
//        }
//        return dp[n - 1][k][0];
//    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        // 限制了两笔交易
        int k = 2;
        int dp_i10 = 0;
        int dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0;
        int dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);

        }
        return dp_i20;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{
                1,2,3,4,5
        };
        System.out.println(new Hard_123().maxProfit(prices));
    }
}
