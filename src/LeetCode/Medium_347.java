package LeetCode;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 链表数组、最大堆
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 */
public class Medium_347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        //Java 的new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2)); 中，入队后排序方法会实时调用map#get 方法进行节点调整。 可以考虑封装为对象放入。

        //堆中为频率最大前k个元素
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        List<Integer> res = new LinkedList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Medium_347 medium_347 = new Medium_347();
        int[] array = {1,1,1,2,2,3,3,3,3,3};
        List<Integer> res = medium_347.topKFrequent(array, 2);
        System.out.println(res);
    }
}
