package LeetCode.second_0628;

import java.util.Arrays;

/*
415. 字符串相加
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

提示：

num1 和num2 的长度都小于 5100
num1 和num2 都只包含数字 0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */
public class Simple_415 {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int i = len1 - 1;
        int j = len2 - 1;
        char[] c = new char[Math.max(len1,len2) + 1];
        int z = Math.max(len1,len2);
        int temp = 0;
        while (i >= 0 || j >= 0) {
            int sum = temp;
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }
            temp = sum / 10;
            c[z] = (char) ((sum % 10) + 48);
            z--;
        }
        c[z] = (char) (temp + 48);
        String res = new String(c);
        return res.charAt(0) == '0' ? res.substring(1) : res;
    }

    public static void main(String[] args) {
//        String num1 = "123";
//        String num2 = "4567";

//        String num1 = "0";
//        String num2 = "0";

        String num1 = "98";
        String num2 = "9";
        System.out.println(new Simple_415().addStrings(num1, num2));
    }
}
