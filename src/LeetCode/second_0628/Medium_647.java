package LeetCode.second_0628;
/*
647. 回文子串
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

示例 1：

输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

提示：

输入的字符串长度不会超过 1000 。
 */
public class Medium_647 {

    public int countSubstrings(String s) {
        int len = s.length();
        int count = len;
        for (int i = 0; i < len; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
            left = i - 1;
            right = i;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String a = "aaa";//6
        String b = "abc";//3
        String c = "abccba";//6+3=9
        String d = "abbcca";//6+2=8
        String e = "ababa";//5+3+1=9
        Medium_647 medium_647 = new Medium_647();
        System.out.println(medium_647.countSubstrings(a));
        System.out.println(medium_647.countSubstrings(b));
        System.out.println(medium_647.countSubstrings(c));
        System.out.println(medium_647.countSubstrings(d));
        System.out.println(medium_647.countSubstrings(e));
    }
}
