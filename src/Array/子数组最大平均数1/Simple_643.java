package Array.子数组最大平均数1;
/*
643. 子数组最大平均数 I
给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

示例：

输入：[1,12,-5,-6,50,3], k = 4
输出：12.75
解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75

提示：

1 <= k <= n <= 30,000。
所给数据范围 [-10,000，10,000]。
 */
public class Simple_643 {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int right = 0;
        int sum = 0;
        while (right < k) {
            sum += nums[right];
            right++;
        }
        int max = sum;
        while (right < len) {
            sum -= nums[right - k];
            sum += nums[right];
            right++;
            max = Math.max(max, sum);
        }
        System.out.println(max);
        return (double) max / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(new Simple_643().findMaxAverage(nums, k));
    }
}
