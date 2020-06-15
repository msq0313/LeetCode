package LeetCode;

/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

 */
public class Simple_14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        boolean flag = false;
        int num = strs.length;
        if (num == 0) {
            return res.toString();
        }
        int minlength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minlength)
                minlength = str.length();
        }
        for (int i = 0; i < minlength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < num; j++) {
                if (c == strs[j].charAt(i))  {
                    if (j == num - 1) {
                        res.append(c);
                        break;
                    }
                } else{
                    return res.toString();
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        String[] strs = {
//                "flower", "flow", "flight"
//        };
        String[] strs = {
                "aca", "cba"
        };
        System.out.println(new Simple_14().longestCommonPrefix(strs));
    }
}
