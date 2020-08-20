package DFS;

import java.util.Arrays;

/*
130. 被围绕的区域
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Medium_130 {

    int[] x = {0, 0, -1, 1};
    int[] y = {-1, 1, 0, 0};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        boolean[] isValid = new boolean[m * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    bfs(board, isValid,i, j);
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (!isValid[i * m + j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(char[][] board, boolean[] isValid, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        if (board[i][j] == 'O') {
            isValid[i * m + j] = true;
            for (int k = 0; k < 4; k++) {
                int yi = i + y[k];
                int xj = j + x[k];
                if (xj >= 0 && xj < m && yi >= 0 && yi < n && !isValid[yi * m + xj]) {
                    bfs(board, isValid, yi, xj);
                }
            }
        }
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };

//        char[][] board = {
//                {'X', 'O', 'X'},
//                {'O', 'X', 'O'},
//                {'X', 'O', 'X'}
//        };

        new Medium_130().solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
