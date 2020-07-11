package LeetCode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

/*
很多形如[start,end]的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间。
 */
public class IntervalScheduling {
    int intervalScheduling(int[][] ints) {
        if (ints.length == 0) {
            return 0;
        }
        int res = 1;
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int x = ints[0][1];
        for (int i = 1; i < ints.length; i++) {
            if (ints[i][0] >= x) {
                x = ints[i][1];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1, 3},
                {6, 7},
                {3, 6}
        };
        System.out.println(new IntervalScheduling().intervalScheduling(ints));
    }
}
