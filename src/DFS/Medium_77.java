package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Medium_77 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new LinkedList<>();
        boolean[] isUsed = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            backtrack(i, n, k, track, isUsed);
            track.remove(track.size() - 1);
        }
        return res;
    }

    private void backtrack(int i,int n, int k, List<Integer> track, boolean[] isUsed) {
        if (!isUsed[i]) {
            isUsed[i] = true;
            track.add(i);
            if (track.size() == k) {
                res.add(new ArrayList<>(track));
                return;
            }
            for (int j = i + 1; j <= n; j++) {
                backtrack(j, n, k, track, isUsed);
                int index = track.get(track.size() - 1);
                isUsed[index] = false;
                track.remove(track.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> list = new Medium_77().combine(n, k);
        System.out.println(list);
    }
}
