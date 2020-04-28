package LeetCode;

import java.util.Arrays;

/*
面试题56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]

限制：

2 <= nums <= 10000
 */
public class Interview_56 {
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int tmp = 0;
        for (int n : nums) {
            tmp ^= n;
        }
        int h = 1;
        while ((tmp & h) == 0)
            h <<= 1;
        for (int n : nums) {
            if ((n & h) == 0) {
                res[0] ^= n;
            } else
                res[1] ^= n;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,4,6};
        System.out.println(Arrays.toString(new Interview_56().singleNumbers(nums)));
    }
}
