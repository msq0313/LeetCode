package DP;
/*
1 5 8 9 10 17 17 20 24 30
1 5 8 10 13 17 18 21 24 30
 */
public class SteelCutting {
    public int maxvalue(int[] nums, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i - j - 1]);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 5, 8, 9, 10, 17, 17, 20, 24, 30
        };
        int n = 4;
        System.out.println(new SteelCutting().maxvalue(nums,5));
    }
}
