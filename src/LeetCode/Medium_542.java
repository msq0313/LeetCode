package LeetCode;
/*
542. 01 矩阵
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1:
输入:

0 0 0
0 1 0
0 0 0
输出:

0 0 0
0 1 0
0 0 0
示例 2:
输入:

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1
注意:

给定矩阵的元素个数不超过 10000。
给定矩阵中至少有一个元素是 0。
矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */

public class Medium_542 {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.MAX_VALUE / 2;
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                }
            }
        }
        //左上至右下
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    res[i][j] = Math.min(res[i - 1][j] + 1, res[i][j]);
                }
                if (j > 0) {
                    res[i][j] = Math.min(res[i][j - 1] + 1, res[i][j]);
                }
            }
        }

        //左下至右上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i < m - 1) {
                    res[i][j] = Math.min(res[i + 1][j] + 1, res[i][j]);
                }
                if (j > 0) {
                    res[i][j] = Math.min(res[i][j - 1] + 1, res[i][j]);
                }
            }
        }

        //右上至左下
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (i > 0) {
                    res[i][j] = Math.min(res[i - 1][j] + 1, res[i][j]);
                }
                if (j < n - 1) {
                    res[i][j] = Math.min(res[i][j + 1] + 1, res[i][j]);
                }
            }
        }

        //右下至左上
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    res[i][j] = Math.min(res[i + 1][j] + 1, res[i][j]);
                }
                if (j < n - 1) {
                    res[i][j] = Math.min(res[i][j + 1] + 1, res[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 1}
        };
        Medium_542 medium_542 = new Medium_542();
        int[][] res = medium_542.updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
