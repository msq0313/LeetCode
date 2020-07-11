package LeetCode.second_0628;
/*
409. 最长回文串
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Simple_409 {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        int res = s.length();
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - '0']++;
        }
        boolean flag = true;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] %2 == 1) {
                flag = false;
                res--;
            }
        }
        return flag ? res : res + 1;
    }

    public static void main(String[] args) {
        String s = "bananas";
        System.out.println(new Simple_409().longestPalindrome(s));

    }
}
