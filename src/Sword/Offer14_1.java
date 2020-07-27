package Sword;
/*
剑指 Offer 14- I. 剪绳子
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：

2 <= n <= 58
 */
public class Offer14_1 {
    // dp
//    public int cuttingRope(int n) {
//        if (n <= 3) {
//            return n - 1;
//        }
//        int[] dp = new int[n+1];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 3;
//        for (int i = 4; i <= n; ++i) {
//            int max = Integer.MIN_VALUE;
//            for (int j = 1; j <= i / 2; ++j) {
//                if (max < dp[j] * dp[i - j]) {
//                    max = dp[j] * dp[i - j];
//                    dp[i] = max;
//                }
//            }
//        }
//        return dp[n];
//    }

    // 数学,剩余长度>=5时，尽量分为3和2，剩余长度为4时，分为2和2
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int res = 1;
        int count = n / 3;
        if (n % 3 == 0) {
            res = (int) Math.pow(3, count);
        } else if (n % 3 == 1) {
            --count;
            res = (int) (Math.pow(3, count) * 4);
        } else if (n % 3 == 2)
            res = (int) (Math.pow(3, count) * (n % 3));
        return res;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(new Offer14_1().cuttingRope(n));
    }
}
