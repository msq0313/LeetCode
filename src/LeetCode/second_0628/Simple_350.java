package LeetCode.second_0628;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
350. 两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
进阶:

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Simple_350 {

    // O(mn)
//    public int[] intersect(int[] nums1, int[] nums2) {
//        ArrayList<Integer> list = new ArrayList<>();
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        boolean[] isUsed = new boolean[len2];
//        for (int i = 0; i < len1; i++) {
//            for (int j = 0; j < len2; j++) {
//                if (nums1[i] == nums2[j] && !isUsed[j]) {
//                    list.add(nums2[j]);
//                    isUsed[j] = true;
//                    break;
//                }
//            }
//        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//    }

    // O(mlogm + nlogn)
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res[index] = nums1[i];
                i++;
                j++;
                index++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    // 哈希表
//    public int[] intersect(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            return intersect(nums2, nums1);
//        }
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for (int num : nums1) {
//            int count = map.getOrDefault(num, 0) + 1;
//            map.put(num, count);
//        }
//        int[] intersection = new int[nums1.length];
//        int index = 0;
//        for (int num : nums2) {
//            int count = map.getOrDefault(num, 0);
//            if (count > 0) {
//                intersection[index++] = num;
//                count--;
//                if (count > 0) {
//                    map.put(num, count);
//                } else {
//                    map.remove(num);
//                }
//            }
//        }
//        return Arrays.copyOfRange(intersection, 0, index);
//    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{
                4,9,5
        };
        int[] nums2 = new int[]{
                9,4,9,8,4
        };
        System.out.println(Arrays.toString(new Simple_350().intersect(nums1, nums2)));
    }
}
