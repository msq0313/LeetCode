package LeetCode.second_0628;

import java.util.ArrayDeque;
import java.util.Deque;

/*
7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Simple_7 {
    // 2147483647，注意如何判断超范围s
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if (res < Integer.MIN_VALUE / 10 || res == Integer.MIN_VALUE / 10 && pop < -8) return 0;
            res = res * 10 + pop;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Simple_7().reverse(-123));
    }
}
