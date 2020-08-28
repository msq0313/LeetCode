package DFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Medium_17 {

    Map<Character, String> map;
    List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder sb = new StringBuilder();
        dfs(digits, sb);
        return res;
    }

    public void dfs(String digits, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        Character number = digits.charAt(sb.length());
        String s = map.get(number);
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(digits, sb);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
//        String digits = "234";
        String digits = "3";
        List<String> strings = new Medium_17().letterCombinations(digits);
        System.out.println(strings);
    }
}
