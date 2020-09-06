package Examination.Tencent.exam0823.problem05;

import java.util.Arrays;
/*
第一行输入一个字符串 s，1 <= s.length() <= 400
第二行输入该组有多少个测试 n
后面n行，每行输入两个数字，l，r用空格分割，l和r分别表示s的子串左右边界，1 <= l <= r <= s.length()
例子：
输入
ababa
4
1 5
2 5
1 4
2 4

输出
1
2
2
1

建立一个boolean[s.length()][s.length()]的dp矩阵
i表示子串开始位置，j表示子串结束位置，利用矩阵上三角进行处理该子串是否为回文串
建立一个同等大小的int矩阵res，也是利用上三角存放该子串最少可由多少个回文串组成
 */
public class Main {
    public static void main(String[] args) {
        String s = "ababaccc";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i == j - 1 || dp[i + 1][j - 1];
                }
            }
        }
        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        int[][] res = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                res[i][j] = len;
                if (dp[i][j]) {
                    res[i][j] = 1;
                } else {
                    for (int k = i + 1; k <= j; k++) {
                        res[i][j] = Math.min(res[i][j], res[i][k - 1] + res[k][j]);
                    }
                }
            }
        }
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
