package Sword;
/*
剑指 Offer 12. 矩阵中的路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
提示：

1 <= board.length <= 200
1 <= board[i].length <= 200
 */
public class Offer12 {
    // 回溯法
    int pathLength = 0;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[] visited = new boolean[rows * cols];
        boolean res = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                res = backtrack(board, word, visited, row, col);
                if (res) {
                    return true;
                }
            }
        }
        return res;
    }

    public boolean backtrack(char[][] board, String word, boolean[] visited, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        if (pathLength == word.length()) {
            return true;
        }
        boolean hasPath = false;
        if (row < rows && col < cols && row >= 0 && col >= 0 && !visited[row * cols + col] && word.charAt(pathLength) == board[row][col]) {
            pathLength++;
            visited[row * cols + col] = true;

            hasPath = backtrack(board, word, visited, row - 1, col) ||
                    backtrack(board, word, visited, row, col - 1) ||
                    backtrack(board, word, visited, row + 1, col) ||
                    backtrack(board, word, visited, row, col + 1);

            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(new Offer12().exist(board, word));
    }
}
