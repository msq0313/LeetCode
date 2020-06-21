package LeetCode;
/*
125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

 */
public class Simple_125 {
    public boolean isPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }
        String lower = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if ((int) c >= 48 && (int) c <= 57 || (int) c >= 97 && (int) c <= 122) {
                sb.append(c);
            }
        }
        for (int i = 0, j = sb.length() - 1; i < sb.length() / 2; i++, j--) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "A";
        System.out.println(new Simple_125().isPalindrome(s));
    }
}
