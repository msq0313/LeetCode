package Basic;

import java.util.Arrays;

/*
0-1背包问题
动态规划
注意下标
 */
public class backpackage_01 {
    public int maxval(int W, int[] wt, int[] val) {
        int N = wt.length;
        //dp table初始化，因为要保存W为0与N为0的情况，多增加一行一列，dp[][0]=0，dp[0][]=0
        //dp[i][j]定义：前i个元素中，背包可以放置的重量为j时，所能放下物品的最大值
        //dp[N][W]即为所求
        int[][] dp = new int[N + 1][W + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j - wt[i - 1] < 0) {
                    dp[i][j] =dp[i - 1][j];
                }
                else
                    //在将新元素放进背包，或不放入而使用旧元素之间进行选择，挑选价值最大的
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
            }
        }
        return dp[N][W];
    }
    public static void main(String[] args) {
        int W = 4;
        int[] wt = new int[]{
                2, 1, 3
        };
        int[] val = new int[]{
                4, 2, 3
        };
        System.out.println(new backpackage_01().maxval(W, wt, val));

    }
}
