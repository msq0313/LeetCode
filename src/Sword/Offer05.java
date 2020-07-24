package Sword;
/*
剑指 Offer 05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."

限制：

0 <= s 的长度 <= 10000
 */
public class Offer05 {
    public String replaceSpace(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                res.append("%20");
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        String s = "We are happy.";
        String s = "    ";
        System.out.println(new Offer05().replaceSpace(s));
    }
}
