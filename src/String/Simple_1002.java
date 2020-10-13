package String;

import java.util.ArrayList;
import java.util.List;

/*
1002. 查找常用字符
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

你可以按任意顺序返回答案。

示例 1：

输入：["bella","label","roller"]
输出：["e","l","l"]
示例 2：

输入：["cool","lock","cook"]
输出：["c","o"]

提示：

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] 是小写字母
 */
public class Simple_1002 {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int n = A.length;
        if (n == 0) {
            return res;
        }
        int[][] nums = new int[n][26];
        for (int i = 0; i < n; i++) {
            String s = A[i];
            for (int j = 0; j < s.length(); j++) {
                nums[i][s.charAt(j) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, nums[j][i]);
            }
            for (int i1 = 0; i1 < min; i1++) {
                res.add(String.valueOf((char) ('a' + i)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        List<String> res = new Simple_1002().commonChars(A);
        System.out.println(res);
    }
}
