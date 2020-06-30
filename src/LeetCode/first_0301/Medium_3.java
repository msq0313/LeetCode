package LeetCode.first_0301;

import java.util.HashSet;
import java.util.Set;

/*
3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Medium_3 {
    //左右指针，滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        int[] freq = new int[128];
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (++freq[c] == 1) {
                res = Math.max(res, right - left);
            } else {
                while (freq[c] == 2) {
                    char d = s.charAt(left);
                    freq[d]--;
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Medium_3().lengthOfLongestSubstring("abcabcbb"));
    }
}

