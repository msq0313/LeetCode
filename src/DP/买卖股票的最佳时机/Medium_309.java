package DP.买卖股票的最佳时机;
/*
309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]

 */
public class Medium_309 {
    public int maxProfit(int[] prices) {
        // 有冷冻期

        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        int dp_pre0 = 0;
        for (int price : prices) {
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + price);
            dp_i1 = Math.max(dp_i1, dp_pre0 - price);
            dp_pre0 = temp;
        }
        return dp_i0;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{
                2,1,4
//                7,1,5,3,6,4
        };
        System.out.println(new Medium_309().maxProfit(prices));
    }
}
