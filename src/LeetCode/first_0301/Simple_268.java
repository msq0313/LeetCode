package LeetCode.first_0301;
/*
268. 缺失数字
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8

说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

 */
public class Simple_268 {
    public int missingNumber(int[] nums) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int sum = (min + max) * (max - min + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        if (sum == 0) {
            if (min == 0) {
                sum = max + 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{
//                9,6,4,2,3,5,7,0,1
//        };

//        int[] nums = new int[]{
//                3,0,1
//        };

        int[] nums = new int[]{
                0
        };
        System.out.println(new Simple_268().missingNumber(nums));

    }
}
