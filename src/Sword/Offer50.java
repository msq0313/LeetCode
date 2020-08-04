package Sword;
/*
剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "

限制：

0 <= s 的长度 <= 50000
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        int[] memo = new int[26];
        char res = ' ';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            memo[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (memo[c - 'a'] == 1) {
                res = c;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Offer50().firstUniqChar(s));
    }
}
