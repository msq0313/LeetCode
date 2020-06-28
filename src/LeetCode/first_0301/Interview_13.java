package LeetCode.first_0301;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 1：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
public class Interview_13 {
    boolean[][] visited;
    int m, n, k;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    //DFS，方向为右下
    public int dfs(int i, int j, int i_s, int j_s) {
        if (i >= m || j >= n || visited[i][j] || k < i_s + j_s) {
            return 0;
        }
        visited[i][j] = true;
        return (1 + dfs(i, j + 1, i_s, (j + 1) % 10 == 0 ? j_s - 8 : j_s + 1) +
                dfs(i + 1, j, (i + 1) % 10 == 0 ? i_s - 8 : i_s + 1, j_s));
    }

    //广度优先搜索DBS，方向为右下
    public int movingCount2(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] num = queue.poll();
            int i = num[0];
            int j = num[1];
            if (i < 0 || i >= m || j < 0 || j >= n || sum(i) + sum(j) > k || visited[i][j])
                continue;
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i, j + 1});
        }
        return res;
    }

    private int sum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Interview_13().movingCount(2, 3, 1));
    }
}
