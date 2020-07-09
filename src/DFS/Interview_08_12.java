package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
面试题 08.12. 八皇后
设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。

注意：本题相对原题做了扩展

示例:

 输入：4
 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
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
public class Interview_08_12 {

    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        LinkedList<String> track = new LinkedList<>();
        boolean[] isUsed = new boolean[n];
        trackback(track, isUsed);
        return res;
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
        List<List<String>> res = new Interview_08_12().solveNQueens(4);
        for (List<String> re : res) {
            for (String r : re) {
                System.out.println(r);
            }
            System.out.println();
        }
        System.out.println("共" + res.size() + "种");
    }
}
