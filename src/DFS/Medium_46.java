package DFS;

import java.util.*;

/*
46. 全排列
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
    // 成员变量保存结果
    List<List<Integer>> res = new ArrayList<>();
    // 给出数组，返回路径集合
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        // 建立路径
        LinkedList<Integer> stack = new LinkedList<>();
        trackback(nums, stack);
        return res;
    }
    // DFS，或者叫回溯法
    public void trackback(int[] nums, LinkedList<Integer> stack) {
        // 终止条件，路径长度等于给定的数组长度
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        // 在数组中给选择
        for (int num : nums) {
            // 路径中已存在则跳过
            if (stack.contains(num)) continue;
            stack.addLast(num);
            // 使用当前路径进入下一层决策树
            trackback(nums, stack);
            // 回溯，删除最后添加的元素
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
