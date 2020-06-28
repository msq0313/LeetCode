package LeetCode.first_0301;
/*
面试题64. 求1+2+…+n
示例 1：

输入: n = 3
输出: 6
示例 2：

输入: n = 9
输出: 45

限制：

1 <= n <= 10000
 */
public class Interview_64 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Interview_64().sumNums(4));
    }
}
