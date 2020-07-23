package Examination.ByteDance;

import java.util.PriorityQueue;

// 求无序数组中位数
public class UnorderedArrayMedian {
    // 堆排序
    public float solution(int[] nums) {
        float res = 0;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                min.add(nums[i]);
            } else {
                max.add(nums[i]);
            }
            // 每次将最小堆顶插入最大堆尾部，最大堆顶部插入最小堆尾部
            if (!min.isEmpty() && !max.isEmpty()) {
                max.add(min.poll());
                min.add(max.poll());
            }
        }
        // 最后最小堆顶>=最大堆顶，数组长度为奇数时，最小堆顶为中位数，偶数时，两个堆顶相加/2
        if (nums.length % 2 == 1) {
            res = min.peek();
        } else res = (float) (min.peek() + max.peek()) / 2;
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{
                2,1,9,7,4,8
        };
        System.out.println(new UnorderedArrayMedian().solution(nums));
    }
}
