package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
322. 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1

 */
public class Medium_322 {
    //使用HashMap记录
//    public int coinChange(int[] coins, int amount) {
//        Map<Integer,Integer> note = new HashMap<>();
//        note.put(0, 0);
//        return dp(coins, amount, note);
//    }
//
//    //函数功能为，传入amount，输出最少用的硬币数
//    public int dp(int[] coins, int amount, Map<Integer,Integer> note) {
//        if (note.containsKey(amount)) {
//            return note.get(amount);
//        }
//        if (amount == 0) {
//            return 0;
//        }
//        if (amount < 0) {
//            return -1;
//        }
//        int res = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int sub = dp(coins,amount - coin, note);
//            if (sub == -1) continue;
//            res = Math.min(res, 1 + sub);
//        }
//        res = res == Integer.MAX_VALUE ? -1 : res;
//        note.put(amount,res);
//        return res;
//    }
//
//    public int coinChange(int[] coins, int amount) {
//        Map<Integer,Integer> note = new HashMap<>();
//        note.put(0, 0);
//        return dp(coins, amount, note);
//    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = new int[]{
                1, 2, 5
        };
        int amount = 11;

//        int[] coins = new int[]{
//                2
//        };
//        int amount = 3;

        System.out.println(new Medium_322().coinChange(coins, amount));
    }
}
