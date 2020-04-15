package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/*
56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

 */
public class Medium_56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        ArrayList<int[]> list = new ArrayList<>();

        //按第一位大小排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= list.get(list.size() - 1)[1]) {
                int[] tmp = new int[2];
                tmp[0] = list.get(list.size() - 1)[0];
                tmp[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
                list.remove(list.size() - 1);
                list.add(tmp);
            } else {
                list.add(intervals[i]);
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {15, 18},
                {1, 3},
                {8, 10},
                {2, 6}
        };
        Medium_56 medium_56 = new Medium_56();
        int[][] res = medium_56.merge(intervals);
        for (int[] re : res) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(re[j] + " ");
            }
            System.out.println();
        }
    }
}
