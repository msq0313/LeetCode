package LeetCode.second_0628;

import java.util.*;

/*
面试题 16.11. 跳水板
你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。

返回的长度需要从小到大排列。

示例：

输入：
shorter = 1
longer = 2
k = 3
输出： {3,4,5,6}
提示：

0 < shorter <= longer
0 <= k <= 100000
 */
public class Interview_16_11 {

    // TreeSet
//    public int[] divingBoard(int shorter, int longer, int k) {
//        if (k == 0) {
//            return new int[0];
//        }
//
//        Set<Integer> set = new TreeSet<>();
//        for (int i = 0; i <= k; i++) {
//            set.add(shorter * i + longer * (k - i));
//        }
//        int[] res = new int[set.size()];
//        int i = 0;
//        for (Integer integer : set) {
//            res[i] = integer;
//            i++;
//        }
//        return res;
//    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <= k; i++) {
            int cur = longer * i + shorter * (k - i);
            if (queue.size() == 0 || queue.peekLast() != cur) {
                queue.addLast(cur);
            }
        }
        int[] res = new int[queue.size()];
        int i = 0;
        for (Integer integer : queue) {
            res[i] = integer;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int shorter = 1;
        int longer = 2;
        int k = 3;

        System.out.println(Arrays.toString(new Interview_16_11().divingBoard(shorter, longer, k)));
    }
}
