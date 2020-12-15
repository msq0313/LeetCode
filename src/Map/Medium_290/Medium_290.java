package Map.Medium_290;

import java.util.HashMap;
import java.util.Map;

/*
290. 单词规律
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Medium_290 {
    public boolean wordPattern(String pattern, String s) {
        boolean res = true;
        HashMap<Character, String> map = new HashMap<>();
        int len = pattern.length();
        String[] ss = s.split(" ");
        if (len != ss.length) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(ss[i])) {
                    res = false;
                    break;
                }
            } else {
                for (Map.Entry<Character, String> characterStringEntry : map.entrySet()) {
                    if (characterStringEntry.getValue().equals(ss[i])) {
                        res = false;
                        break;
                    }
                }
                map.put(c, ss[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";

//        String pattern = "abba";
//        String s = "dog dog dog dog";
        System.out.println(new Medium_290().wordPattern(pattern, s));
    }
}
