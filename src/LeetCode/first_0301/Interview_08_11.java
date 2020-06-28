package LeetCode.first_0301;

/*
面试题 08.11. 硬币
硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)

示例1:

 输入: n = 5
 输出：2
 解释: 有两种方式可以凑成总金额:
5=5
5=1+1+1+1+1
示例2:

 输入: n = 10
 输出：4
 解释: 有四种方式可以凑成总金额:
10=10
10=5+5
10=5+1+1+1+1+1
10=1+1+1+1+1+1+1+1+1+1
说明：

注意:

你可以假设：

0 <= n (总金额) <= 1000000
 */
public class Interview_08_11 {

    private final int M = 1000000007;
    private final int[] D = {25, 10, 5, 1};

    public int waysToChange(int n) {
        int[] num = new int[n + 1];
        num[0] = 1;
        for (int d = 0; d < 4; d++) {
            int val = D[d];
            for (int i = val; i <= n; i++) {
                num[i] = (num[i] + num[i - val]) % M;
            }
        }
        return num[n];
    }

    public static void main(String[] args) {
        System.out.println(new Interview_08_11().waysToChange(5));
    }
}
