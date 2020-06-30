package LeetCode.second_0628;

import java.util.LinkedList;
import java.util.List;
/*
438. 找到字符串中所有字母异位词
给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：

字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

 示例 2:

输入:
s: "abab" p: "ab"

输出:
[0, 1, 2]

 */
public class Medium_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int left = 0;
        int right = 0;
        int[] freq = new int[128];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i)]++;
        }
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (--freq[c] >= 0) {
                valid++;
            }
            if (right > p.length()) {
                char d = s.charAt(left);
                left++;
                if (++freq[d] > 0) {
                    valid--;
                }
            }
            if (valid == p.length())
                res.add(left);
        }
        return res;
    }
    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";

        String s = "abab";
        String p = "ab";

        System.out.println(new Medium_438().findAnagrams(s, p));
    }
}
