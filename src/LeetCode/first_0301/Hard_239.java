package LeetCode.first_0301;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 */
public class Hard_239 {
    private ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    private int[] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        //处理特殊输入
        if (len * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        //初始化双端队列前k位，初始化输出数组第一位
        this.nums = nums;
        int maxid = 0;
        for (int i = 0; i < k; i++) {
            clean(i, k);
            deq.addLast(i);
            if (nums[i] > nums[maxid]) {
                maxid = i;
            }
        }
        int[] res = new int[len - k + 1];
        res[0] = nums[maxid];
        //之后的窗口，先清理队列再加入输出数组
        for (int i = k; i < len; i++) {
            clean(i, k);
            deq.addLast(i);
            res[i - k + 1] = nums[deq.getFirst()];
        }
        return res;
    }

    private void clean(int i, int k) {
        //清除过早的前端
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }
        //清除比当前值小的后端
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
        //此时队列第一个元素对应的值就是最大值
    }

    public static void main(String[] args) {
        Hard_239 hard_239 = new Hard_239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = hard_239.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
