package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
52. N皇后 II
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]

 */
public class Hard_52 {
    List<List<String>> res = new LinkedList<>();
    public int totalNQueens(int n) {
        LinkedList<String> track = new LinkedList<>();
        boolean[] isUsed = new boolean[n];
        trackback(track, isUsed);
        return res.size();
    }

    public void trackback(LinkedList<String> track, boolean[] isUsed) {
        if (track.size() == isUsed.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        int n = isUsed.length;
        char[] ch = new char[n];
        Arrays.fill(ch, '.');

        for (int i = 0; i < n; i++) {
            if (isUsed[i]) {
                continue;
            }
            if (isValid(track, i)) {
                ch[i] = 'Q';
//                System.out.println(String.valueOf(ch));
                track.addLast(String.valueOf(ch));
                isUsed[i] = true;
                trackback(track, isUsed);
                track.removeLast();
                ch[i] = '.';
                isUsed[i] = false;
            }
        }
    }
    //是否能放皇后
    public boolean isValid(List<String> track, int row) {
        int col = track.size();
        if (col == 0) {
            return true;
        }
        for (int i = 0; i < col; i++) {
            String sb = track.get(i);
            //垂直方向无皇后
            if (sb.charAt(row) == 'Q') {
                return false;
            }
            //左上方无皇后
            if (row - col + i >= 0 && sb.charAt(row - col + i) == 'Q') {
                return false;
            }
            //右上方无皇后
            if (row + col - i < sb.length() && sb.charAt(row + col - i) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int res = new Hard_52().totalNQueens(4);
        System.out.println(res);
    }
}
