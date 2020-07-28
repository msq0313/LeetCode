package Sword;

import java.util.ArrayList;
import java.util.Arrays;

/*
剑指 Offer 17. 打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

说明：

用返回一个整数列表来代替打印
n 为正整数
 */
public class Offer17 {
    // 用字符串处理，注重进位问题

    // 常规方法
//    public int[] printNumbers(int n) {
//        ArrayList<Integer> list = new ArrayList<>();
//        int N = (int) Math.pow(10, n);
//        int[] res = new int[N - 1];
//        for (int i = 1; i < N; i++) {
//            res[i - 1] = i;
//        }
//        return res;
//    }

    // 针对大数，全排列，DFS/回溯
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        // 位数n
        this.n = n;
        // 结果数组
        res = new int[(int)Math.pow(10, n) - 1];
        // 字符数组
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        // x为层数
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }

        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(new Offer17().printNumbers(n)));
    }
}
