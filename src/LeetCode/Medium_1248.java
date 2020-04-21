package LeetCode;

import java.util.Arrays;

/*
1248. 统计「优美子数组」
给你一个整数数组 nums 和一个整数 k。

如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。

示例 1：

输入：nums = [1,1,2,1,1], k = 3
输出：2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
示例 2：

输入：nums = [2,4,6], k = 1
输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。
示例 3：

输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
输出：16

提示：

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
 */
public class Medium_1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        int len = nums.length;
        int l = 0;
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                l++;
            }
        }
        System.out.println(l);
        int[] d = new int[l + 1];
        for (int i = 0, j = 0; i < len; i++) {
            count++;
            if (nums[i] % 2 == 1) {
                d[j++] = count;
                count = 0;
            }
        }
        d[l] = count + 1;
        System.out.println(Arrays.toString(d));

        for (int i = 0; i + k - 1 < l; i++) {
            res += d[i] * d[i + k];
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
//        int k = 2;
        int[] nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 2};
        int k = 2;
        Medium_1248 medium_1248 = new Medium_1248();
        System.out.println(medium_1248.numberOfSubarrays(nums, k));
    }
}
