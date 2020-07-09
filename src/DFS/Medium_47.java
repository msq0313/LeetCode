package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
47. 全排列 II
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

 */
public class Medium_47 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] isUsed = new boolean[nums.length];
        trackback(nums, track, isUsed);
        return res;
    }

    public void trackback(int[] nums, LinkedList<Integer> track, boolean[] isUsed) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !isUsed[i - 1])
                continue;
            track.addLast(nums[i]);
            isUsed[i] = true;
            trackback(nums, track, isUsed);
            track.removeLast();
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> res =  new Medium_47().permuteUnique(nums);
        for (List<Integer> m : res) {
            for (Integer n : m) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
