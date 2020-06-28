package LeetCode.first_0301;
/*
69. x 的平方根
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。

 */
public class Simple_69 {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        return deal(0, x, x);
    }

    public int deal(int low, int high, int x) {
        int middle = low + (high - low) / 2;
        if (Math.pow(middle, 2) == x) {
            return middle;
        }
        if (Math.pow(middle, 2) > x) {
            return deal(low, middle, x);
        }
        if (Math.pow(middle, 2) < x && Math.pow(middle + 1, 2) < x) {
            return deal(middle, high, x);
        }
        if (Math.pow(middle + 1, 2) == x) {
            return middle + 1;
        }
        return middle;
    }

    //袖珍计算器法
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int)Math.exp(0.5 * Math.log(x));
        return (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }


    public static void main(String[] args) {
        System.out.println(new Simple_69().mySqrt(8));
        System.out.println(new Simple_69().mySqrt(4));
    }
}
