package Examination.Tencent.exam0908.test;
/*
题目描述
对输入的字符串进行排序后输出
输入描述:
输入有两行，第一行n

第二行是n个空格隔开的字符串
输出描述:
输出一行排序后的字符串，空格隔开，无结尾空格
示例1
输入
复制
5
c d a bb e
输出
复制
a bb c d e
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(input.next());
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
