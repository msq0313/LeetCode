package LeetCode;
/*
200. 岛屿数量
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

示例 1:

输入:
11110
11010
11000
00000
输出: 1
示例 2:

输入:
11000
11000
00100
00011
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

 */
public class Medium_200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int i, int j, char[][] grid) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (i - 1 >= 0) {
                dfs(i - 1, j, grid);
            }
            if (j + 1 < grid[0].length) {
                dfs(i, j + 1, grid);
            }
            if (i + 1 < grid.length) {
                dfs(i + 1, j, grid);
            }
            if (j - 1 >= 0) {
                dfs(i, j - 1, grid);
            }
        }

    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
//        char[][] grid = new char[][]{
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'},
//        };
        Medium_200 medium_200 = new Medium_200();
        System.out.println(medium_200.numIslands(grid));
    }
}
