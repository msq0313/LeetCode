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

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        trackback(nums, stack);
        return res;
    }

    public void trackback(int[] nums, LinkedList<Integer> stack) {
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int num : nums) {
            if (stack.contains(num)) continue;
            stack.addLast(num);
            trackback(nums, stack);
            stack.removeLast();
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
