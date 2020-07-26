package Sword;
/*
剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20
 */
public class Offer13 {
    int res = 0;
    public int movingCount(int m, int n, int k) {
        int i = 0;
        int j = 0;
        boolean[] isVisited = new boolean[m * n];
        dfs(m, n, i, j, k, isVisited);
        return res;
    }

    public void dfs(int m, int n, int i, int j, int k, boolean[] isVisited) {
        if (i >= 0 && j >= 0 && i < m && j < n && isValid(i, j, k) && !isVisited[i * n + j]) {
            ++res;
            isVisited[i * n + j] = true;
        } else return;
        dfs(m, n, i + 1, j, k, isVisited);
        dfs(m, n, i, j + 1, k, isVisited);
    }

    public boolean isValid(int i, int j, int k) {
        int sumi = 0;
        int sumj = 0;
        boolean res = false;
        while (i > 0) {
            sumi += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sumj += j % 10;
            j /= 10;
        }
        if (sumi + sumj <= k) {
            res = true;
        }
        return res;
    }

    public static void main(String[] args) {
//        int m = 2, n = 3, k = 1;
        int m = 3, n = 2, k = 17;
        System.out.println(new Offer13().movingCount(m, n, k));
    }
}
