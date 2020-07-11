package LeetCode.双指针;
/*
5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */
public class Medium_5 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = minString(s, i, i);
            String s2 = minString(s, i, i + 1);
            res = res.length() >= s1.length() ? res : s1;
            res = res.length() >= s2.length() ? res : s2;
        }
        return res;
    }

    public String minString(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new Medium_5().longestPalindrome(s));
    }
}
