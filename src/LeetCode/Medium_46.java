package LeetCode;

import java.util.*;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 */
public class Medium_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, stack, used, res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, Deque<Integer> stack, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            stack.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, stack, used, res);
            stack.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res =  new Medium_46().permute(nums);
        for (List<Integer> m : res) {
            for (Integer n : m) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
