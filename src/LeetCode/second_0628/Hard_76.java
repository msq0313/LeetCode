package LeetCode.second_0628;

import java.util.HashMap;
import java.util.Map;

/*
76. 最小覆盖子串
给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。

 */
public class Hard_76 {

//    //滑动窗口哈希表解法
//    public String minWindow(String s, String t) {
//        Map<Character, Integer> need = new HashMap<>();
//        Map<Character, Integer> window = new HashMap<>();
//        //初始化need表
//        for (int i = 0; i < t.length(); i++) {
//            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
//        }
//        //定义变量
//        int left = 0;
//        int right = 0;
//        int valid = 0;
//        int start = 0;
//        int len = Integer.MAX_VALUE;
//        //遍历字符串，扩展右边界
//        while (right < s.length()) {
//            char c = s.charAt(right);
//            right++;
//            //当需要此字符时，更新窗口字符大小
//            if (need.containsKey(c)) {
//                window.put(c, window.getOrDefault(c, 0) + 1);
//                //窗口中字符计数等于需求时，valid++
//                if (window.get(c).equals(need.get(c))) {
//                    valid++;
//                }
//            }
//            //当各位均符合条件时valid == t.length()，不断收缩窗口
//            while (valid == need.size()) {
//                //更新最小长度
//                if (right - left < len) {
//                    start = left;
//                    len = right - left;
//                }
//                //左边界收缩
//                char d = s.charAt(left);
//                left++;
//                //更新窗口值
//                if (need.containsKey(d)) {
//                    if (window.get(d).equals(need.get(d))) {
//                        valid--;
//                    }
//                    window.put(d, window.get(d) - 1);
//                }
//            }
//        }
//        //返回结果
//        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
//    }

    //滑动窗口数组解法
    public String minWindow(String s, String t) {
        char[] T = t.toCharArray();
        // 使用数组记录每种字符需要的个数，下标为字符对应的数值
        int[] freq = new int[128];
        for (char ch : T) {
            freq[ch]++;
        }
        // 初始化边界值，以及有效计数valid
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        // 遍历字符串
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 窗口右边界扩展
            right++;
            // 更新仍需要的 c 字符个数，更新有效计数valid
            if (--freq[c] >= 0) {
                valid++;
            }
            // 当有效计数等于目标串长度时，窗口左边界收缩
            while (valid == t.length()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 窗口左边界收缩
                left++;
                // 更新仍需要的 d 字符个数，更新有效计数valid
                if (++freq[d] > 0) {
                    valid--;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";

        String s = "aa";
        String t = "aa";
        System.out.println(new Hard_76().minWindow(s, t));
    }
}
