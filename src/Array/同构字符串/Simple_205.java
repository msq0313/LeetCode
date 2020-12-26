package Array.同构字符串;

import java.util.HashMap;

/*
205. 同构字符串
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

输入: s = "egg", t = "add"
输出: true
示例 2:

输入: s = "foo", t = "bar"
输出: false
示例 3:

输入: s = "paper", t = "title"
输出: true
说明:
你可以假设 s 和 t 具有相同的长度。
 */
public class Simple_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> hashMap1 = new HashMap<>();
        HashMap<Character, Character> hashMap2 = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);
            if (hashMap1.containsKey(x) && hashMap1.get(x) != y || hashMap2.containsKey(y) && hashMap2.get(y) != x) {
                return false;
            }
            hashMap1.put(x, y);
            hashMap2.put(y, x);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(new Simple_205().isIsomorphic(s, t));
    }
}
