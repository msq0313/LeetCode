package Examination.Baidu.Interview.q4;
/*
给定一个字符串
输出其中最长无重复字母子串
如：
给定：aabbcdbae  输出：cdbae
给定：abcabcd  输出：abcd
给定：aabbcdd  输出：bcd
 */
public class Main {

    public String maxString(String s) {
        String res = "";
        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int len = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            count[c-'a']++;
            while (count[c-'a'] > 1) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
            if (right - left > len) {
                len = right - left;
                res = s.substring(left, right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "aabbcdbae";
        String s2 = "abcabcd";
        String s3 = "aabbcdd";
        System.out.println(new Main().maxString(s1));
        System.out.println(new Main().maxString(s2));
        System.out.println(new Main().maxString(s3));
    }
}