package LeetCode.second_0628;

import java.util.LinkedList;
import java.util.List;

/*
120. 三角形最小路径和
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分
 */
public class Simple_120 {

    // 从倒数第二层向前迭代
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                cur.set(j, cur.get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

//    public void dp(List<List<Integer>> triangle, int deep) {
//        if (deep == triangle.size()) {
//            return;
//        }
//        dp(triangle, deep + 1);
//        List<Integer> cur = triangle.get(deep);
//        for (int i = 0; i < cur.size(); i++) {
//            cur.set(i, cur.get(i) + Math.min(triangle.get(deep + 1).get(i), triangle.get(deep + 1).get(i + 1)));
//        }
//    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();

        List<Integer> l1 = new LinkedList<>();
        l1.add(2);

        List<Integer> l2 = new LinkedList<Integer>(){{
            add(3);
            add(4);
        }};

        List<Integer> l3 = new LinkedList<Integer>(){{
            add(6);
            add(5);
            add(7);
        }};

        List<Integer> l4 = new LinkedList<Integer>(){{
            add(4);
            add(1);
            add(8);
            add(3);
        }};

        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);

        System.out.println(new Simple_120().minimumTotal(triangle));
    }
}
