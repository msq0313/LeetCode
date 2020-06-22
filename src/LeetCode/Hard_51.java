package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
51. N皇后

n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 */
public class Hard_51 {
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
        List<List<String>> res = new Hard_51().solveNQueens(4);
        for (List<String> re : res) {
            for (String r : re) {
                System.out.println(r);
            }
            System.out.println();
        }
        System.out.println("共" + res.size() + "种");
    }
}
