package Array.字符串中的第一个唯一字符;
/*
387. 字符串中的第一个唯一字符
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

示例：

s = "leetcode"
返回 0

s = "loveleetcode"
返回 2

提示：你可以假定该字符串只包含小写字母。
 */
public class Simple_387 {
    public int firstUniqChar(String s) {
        int res = -1;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "leetcode";
        String s = "loveleetcode";
        System.out.println(new Simple_387().firstUniqChar(s));
    }
}
