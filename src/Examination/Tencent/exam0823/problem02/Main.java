package Examination.Tencent.exam0823.problem02;

import java.util.*;

/*
题目描述
输入一个字符串s，s由小写英文字母组成，保证s长度小于等
于5000并且大于等于1。在s的所有不同的子串中，输出字典
序第k小的字符串。
字符串中任意个连续的字符组成的子序列称为该字符串的子串。
字母序表示英文单词在字典中的先后顺序，即先比较第一个字
母，若第一个字母相同，则比较第二个字母的字典序，依次类
推，则可比较出该字符串的字典序大小。
输入描述:
第一行输出一个字符串s，保证s 长度小于等于5000大于
等于1。
第二行一个整数k (1<= k <= 5)，保证S不同子串个数
大于等于k。
输出描述:
输出一个字符串表示答案。
示例1输入输出示例仅供调试，后台判题数据一般不包含示例
复制
输入
aabb
输出
复制
aab
说明
不同的子串依次为:
a aa aab aabb ab abb b bb
所以答案为aab
 */
public class Main {

    public String helper(String s, int k) {
        TreeSet<String> set = new TreeSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + 5; j++) {
                if (j <= len)
                    set.add(s.substring(i, j));
            }
        }
        List<String> list = new ArrayList<>(set);
        return list.get(k - 1);
    }

    public static void main(String[] args) {
        String s = "aabb";
        int k = 5;
        String res = new Main().helper(s,k);
        System.out.println(res);
    }
}
