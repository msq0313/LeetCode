package LeetCode.second_0628;
/*
718. 最长重复子数组
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。

示例 1:

输入:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出: 3
解释:
长度最长的公共子数组是 [3, 2, 1]。
说明:

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100

 */
public class Medium_718 {
    //dp table
    public int findLength(int[] A, int[] B) {
        //dp[i][j]含义：A[i:]与B[j:]的最长相同前缀
        int n = A.length;
        int m = B.length;
        int res = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{
                1,2,3,2,1
        };
        int[] B = new int[]{
                3,2,1,4,7
        };
        System.out.println(new Medium_718().findLength(A, B));
    }
}
